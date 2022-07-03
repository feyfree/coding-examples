package com.feyfree.work.mysql;

public class ResourceDBInfoDTO {
    private Integer dbId;
    private String dbType;
    private String dataSrcName;
    private String dataSrcDesc;
    private String dbUser;
    private String userPsd;
    private String databaseName;
    private String dbIp;
    private String dbPort;
    private String status;
    private String charSet;
    private String flowLinkId;
    private String operator;
    private String createTime;

    public ResourceDBInfoDTO() {
    }

    public ResourceDBInfoDTO(Integer dbId, String createTime) {
        this.dbId = dbId;
        this.createTime = createTime;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getDataSrcName() {
        return dataSrcName;
    }

    public void setDataSrcName(String dataSrcName) {
        this.dataSrcName = dataSrcName;
    }

    public String getDataSrcDesc() {
        return dataSrcDesc;
    }

    public void setDataSrcDesc(String dataSrcDesc) {
        this.dataSrcDesc = dataSrcDesc;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd == null ? null : userPsd.trim();
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDbIp() {
        return dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    public String getDbPort() {
        return dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getFlowLinkId() {
        return flowLinkId;
    }

    public void setFlowLinkId(String flowLinkId) {
        this.flowLinkId = flowLinkId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
