package com.yklis.lisfunction.entity;

public class ChkValuEntity {

    private String tableName;//chk_valu、chk_valu_bak
    private int valueid;
    private int pkunid;
    private String name;
    private String english_name;
    private String issure;
    private byte[] photo;
    
    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public int getValueid() {
        return this.valueid;
    }

    public void setValueid(int valueid) {
        this.valueid = valueid;
    }
    
    public int getPkunid() {
        return this.pkunid;
    }

    public void setPkunid(int pkunid) {
        this.pkunid = pkunid;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEnglish_name() {
        return this.english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }
        
    public String getIssure() {
        return this.issure;
    }

    public void setIssure(String issure) {
        this.issure = issure;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
