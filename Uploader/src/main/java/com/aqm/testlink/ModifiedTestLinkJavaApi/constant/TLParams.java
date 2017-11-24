package com.aqm.testlink.ModifiedTestLinkJavaApi.constant;

public enum TLParams{

	TYPE("type"),
	COUNT_REQ("countreq"),
	SCOPE("scope"),
	USER_ID("userid"),
	DOCUMENT_ID("documentid");
	
	private String value;

    TLParams(String value) {
        this.value = value;
    }

    /**
     * Print param value.
     * @return param value
     */
    public String toString() {
        return this.value;
    }
}
