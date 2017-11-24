package com.aqm.testlink.ModifiedTestLinkJavaApi.constant;

public enum TLMethods {

	CREATE_REQUIREMENT_SPECIFICATION("tl.createRequirementSpecification"),
	CREATE_REQUIREMENT("tl.createRequirement");
	
	private String value;

    TLMethods(String value) {
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
