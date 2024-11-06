package com.tool.config;

public class ColData {

    private String title;
    private String type;

    private String comment;

    private String value;

    private boolean key;

    public ColData(String title,String type,String comment,boolean key) {
        this.title = title;
        this.type = type;
        this.comment = comment;
        this.key = key;
    }

	public ColData(String title,String type,String comment,String value) {
		this.title = title;
		this.type = type;
		this.comment = comment;
		this.value = value;
	}

    private ColData(String title,String type,String comment,String value,boolean key) {
        this.title = title;
        this.type = type;
        this.comment = comment;
        this.value = value;
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public ColData clone(){
        ColData data = new ColData(title,type,comment,value,key);
        return data;
    }
}
