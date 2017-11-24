package com.aqm.testlink.Dataupaload;

public class Field {
	private String FieldLevel;
	private String FieldName;
	private String TestlinkFieldName;
	private boolean CustomColumn;
	
	Field(String FieldLevel, String FieldName, String TestlinkFieldName, boolean CustomColumn){
		this.FieldLevel = FieldLevel;
		this.FieldName = FieldName;
		this.CustomColumn = CustomColumn;
		this.TestlinkFieldName = TestlinkFieldName;
	}

	public String getFieldLevel() {
		return FieldLevel;
	}

	public void setFieldLevel(String fieldLevel) {
		FieldLevel = fieldLevel;
	}

	public String getFieldName() {
		return FieldName;
	}

	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}

	public boolean isCustomColumn() {
		return CustomColumn;
	}

	public void setCustomColumn(boolean customColumn) {
		CustomColumn = customColumn;
	}

	public String getTestlinkFieldName() {
		return TestlinkFieldName;
	}

	public void setTestlinkFieldName(String testlinkFieldName) {
		TestlinkFieldName = testlinkFieldName;
	}
}
