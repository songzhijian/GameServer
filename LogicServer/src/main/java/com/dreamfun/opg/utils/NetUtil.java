package com.dreamfun.opg.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class NetUtil {

	/** 返回外网IP地址，如果没配置外网IP则返回内网IP */
	public static String getRealIp() {
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP
		try{
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			boolean finded = false;// 是否找到外网IP
			while (netInterfaces.hasMoreElements() && !finded) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> address = ni.getInetAddresses();
				while (address.hasMoreElements()) {
					ip = address.nextElement();
					if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 外网IP
						netip = ip.getHostAddress();
						finded = true;
						break;
					} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
						localip = ip.getHostAddress();
					}
				}
			}
		}catch(Exception e){
		}
		if (netip != null && !"".equals(netip)) {
			return netip;
		} 
		return localip;
	}
	
	
	/** 返回内网IP地址 */
	public static String getHostIp(String localCheckIps){
		String localip = null;
		try{
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> address = ni.getInetAddresses();
				while (address.hasMoreElements()) {
					ip = address.nextElement();
					if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1 && isPreferredAddress(ip,localCheckIps)) {// 内网IP
						localip = ip.getHostAddress();
						return localip;
					}
				}
			}
		}catch(Exception e){
		}
		return localip;
	}



	public static boolean isPreferredAddress (InetAddress address,String localCheckIps) {
		if(StringUtils.isEmpty(localCheckIps)) {
			return true;
		}
		List<String> ips = new ArrayList<>();
		String[] localCheckIpArr = localCheckIps.split(Cat.comma);
		String hostAddress = address.getHostAddress();
		for(String localCheckIp : localCheckIpArr){
			if(hostAddress.contains(localCheckIp) && hostAddress.startsWith(localCheckIp)){
				return true;
			}
		}
		return false;
	}



	
	
	public static void main(String[] args) throws IOException {
//		URL url = new URL("http://172.16.200.66:8001/cgi-bin/serverlist");
//	      //post参数
//	       Map<String,Object> params = new LinkedHashMap<>();
//	            params.put("geomInfo", "");
//	            params.put("f", "json");
//
//	       //开始访问
//	        StringBuilder postData = new StringBuilder();
//	        for (Map.Entry<String,Object> param : params.entrySet()) {
//	            if (postData.length() != 0) postData.append('&');
//	            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//	            postData.append('=');
//	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//	        }
//	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//
//	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//	        conn.setRequestMethod("POST");
//	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
//	        conn.setDoOutput(true);
//	        conn.getOutputStream().write(postDataBytes);
//
//	        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//
//	        StringBuilder sb = new StringBuilder();
//	        for (int c; (c = in.read()) >= 0;)
//	            sb.append((char)c);
//	        String response = sb.toString();
//	        System.out.println(response);
//		String hostIp = getHostIp();
//		String realIp = getRealIp();
//		System.out.println(hostIp+"_"+realIp);
	}
}
