package com.gameengine.system.http;

public class ClientParams {

    private String zone = "";//如果有主动选服走这个字段

    private String deviceId = "";//设备ID

    private String accountId = "";//账号唯一ID

    private String uid = "";//指定登录账号下某个uid

    private String clientVersion = "";//大版本号

    private String clientVersionCode = "";//小版本号

    private String ip = "";//客户端IP

    private String country = "";//所在国家

    private String city = "";//所在城市

    private String platform = "";//所在平台

    private String platformId = "";//平台ID

    private String language = "";//语言

    private String email = "";//邮箱

    private String packageId = "";//包体名称 com.deedledoodle.io.survivor

    private String deviceModelId = "";//设备型号

    private String deviceOs = "";//设备系统 Android Ios

    private String deviceOsVersion = "";//设备系统版本

    private String firebaseId = "";//Firebase SDK 每次上线唯一ID

    private String appsFlyerId = "";

    private String IDFA = "";

    private String GAID = "";

    private String OAID = "";

    private String adId = "";//广告AD层级Id
    private String adName = "";//广告Ad层级名称（素材名称）
    private String adCreativeName = "";//广告创意名称
    private String adCreativeTitle = "";// 广告创意标题
    private String adSetId = "";// 广告AdSet层级ID
    private String adSetName = "";// 广告AdSet层级名称
    private String adCampaignId = "";//广告CampaignID
    private String adCampaignName = "";//广告Campaign名称
    private String adChannel = "";//广告子渠道Channel

    private String GPIR = "";//引荐来源

    private String clickTs = "";//网站点击客户端时间戳

    private String installTs = "";//应用安装客户端时间戳

    private String clickServerTs = "";//网站点击服务器时间戳

    private String installServerTs = "";//应用安装服务器时间戳

    private String isInstantExperienceLaunched = "";//首次安装版本

    private String installVersion = "";//7天内免安装体验
    /**
     * AppStore market_global 渠道类型枚举
     * {@link com.im30.esg.custom.platform.PlayerPlatformEnum } //手写的 以此为准
     * {@link com.im30.esg.common.utils.LogUtils.PlatformType } //根据配置文件生产的 两个通过code关联
     */
    private String platformType = "";

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getClientVersionCode() {
        return clientVersionCode;
    }

    public void setClientVersionCode(String clientVersionCode) {
        this.clientVersionCode = clientVersionCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(String deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setDeviceOsVersion(String deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public String getAppsFlyerId() {
        return appsFlyerId;
    }

    public void setAppsFlyerId(String appsFlyerId) {
        this.appsFlyerId = appsFlyerId;
    }

    public String getIDFA() {
        return IDFA;
    }

    public void setIDFA(String IDFA) {
        this.IDFA = IDFA;
    }

    public String getGAID() {
        return GAID;
    }

    public void setGAID(String GAID) {
        this.GAID = GAID;
    }

    public String getOAID() {
        return OAID;
    }

    public void setOAID(String OAID) {
        this.OAID = OAID;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdCreativeName() {
        return adCreativeName;
    }

    public void setAdCreativeName(String adCreativeName) {
        this.adCreativeName = adCreativeName;
    }

    public String getAdCreativeTitle() {
        return adCreativeTitle;
    }

    public void setAdCreativeTitle(String adCreativeTitle) {
        this.adCreativeTitle = adCreativeTitle;
    }

    public String getAdSetId() {
        return adSetId;
    }

    public void setAdSetId(String adSetId) {
        this.adSetId = adSetId;
    }

    public String getAdSetName() {
        return adSetName;
    }

    public void setAdSetName(String adSetName) {
        this.adSetName = adSetName;
    }

    public String getAdCampaignId() {
        return adCampaignId;
    }

    public void setAdCampaignId(String adCampaignId) {
        this.adCampaignId = adCampaignId;
    }

    public String getAdCampaignName() {
        return adCampaignName;
    }

    public void setAdCampaignName(String adCampaignName) {
        this.adCampaignName = adCampaignName;
    }

    public String getAdChannel() {
        return adChannel;
    }

    public void setAdChannel(String adChannel) {
        this.adChannel = adChannel;
    }

    public String getGPIR() {
        return GPIR;
    }

    public void setGPIR(String GPIR) {
        this.GPIR = GPIR;
    }

    public String getClickTs() {
        return clickTs;
    }

    public void setClickTs(String clickTs) {
        this.clickTs = clickTs;
    }

    public String getInstallTs() {
        return installTs;
    }

    public void setInstallTs(String installTs) {
        this.installTs = installTs;
    }

    public String getClickServerTs() {
        return clickServerTs;
    }

    public void setClickServerTs(String clickServerTs) {
        this.clickServerTs = clickServerTs;
    }

    public String getInstallServerTs() {
        return installServerTs;
    }

    public void setInstallServerTs(String installServerTs) {
        this.installServerTs = installServerTs;
    }

    public String getIsInstantExperienceLaunched() {
        return isInstantExperienceLaunched;
    }

    public void setIsInstantExperienceLaunched(String isInstantExperienceLaunched) {
        this.isInstantExperienceLaunched = isInstantExperienceLaunched;
    }

    public String getInstallVersion() {
        return installVersion;
    }

    public void setInstallVersion(String installVersion) {
        this.installVersion = installVersion;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
