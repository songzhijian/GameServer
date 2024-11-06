package com.gameengine.system.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


public final class GeoIP2Util {
    private static final Logger logger = GameLoggerFactory.getLogger(GeoIP2Util.class);

    private static final GeoIP2Util instance = new GeoIP2Util();

    public static GeoIP2Util getInstance() {
        return instance;
    }

    private GeoIP2Util() {
    }

    private DatabaseReader reader;

    public void init(String dbPath) {
        try {
            File database = new File(dbPath);
            reader = new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            logger.error(" GeoIP2Util load error! ", e);
            System.exit(1);
        }
    }

    public void reload(String dbPath) {
        try {
            File database = new File(dbPath);
            reader = new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            logger.error(" GeoIP2Util reload error! ", e);
            throw new RuntimeException(e);
        }
    }

    public String getCountryISOCode(String ip) {
        if (!IPUtil.isLegalIpv4(ip)) {
            return "illegal";
        }
        if (IPUtil.internalIp(ip)) {//内网IP直接进
            return "inner";
        }

        try {
            CountryResponse response = reader.country(InetAddress.getByName(ip));
            if (response == null) {
                return "unknown";
            }
            return response.getCountry().getIsoCode();
        } catch (IOException | GeoIp2Exception e) {
            logger.warn("country error ip={}, Exception={}", ip, e);
        }

        return "unknown";
    }

    public String getCity(String ip) {
        try {
            CityResponse response = reader.city(InetAddress.getByName(ip));
            City city = response.getCity();
            logger.info("ip={}, Confidence={}, name={}, zh-CN={}", ip, city.getConfidence(), city.getName(), city.getNames().get("zh-CN"));
            return city.getName();
        } catch (IOException | GeoIp2Exception e) {
            logger.warn("city error ip={}, Exception={}", ip, e);
        }
        return null;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\liuxudong\\Documents\\uwserver\\ESGProject\\serverconfig\\GeoIP2-Country.mmdb";
        String ip = "103.130.129.210";
        GeoIP2Util.getInstance().init(path);
        System.out.println(GeoIP2Util.getInstance().getCountryISOCode(ip));
    }
}
