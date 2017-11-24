package com.aqm.testlink.ModifiedTestLinkJavaApi.map;

import java.util.HashMap;
import java.util.Map;
import com.aqm.testlink.ModifiedTestLinkJavaApi.constant.TLParams;
import com.aqm.testlink.ModifiedTestLinkJavaApi.model.RequirmentSpecification;

import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkParams;

public final class Mapping {
	
	public static Object[] EMPTY_ARRAY = new Object[0];
	public Mapping() {
		
	}
	
	public static Map<String, Object> getRequirementSpecificationMap(RequirmentSpecification requirmentSpecification) {
		
		Map<String, Object> executiondata = new HashMap<String, Object>();
		
		executiondata.put(TestLinkParams.TEST_PROJECT_ID.toString(), requirmentSpecification.gettestProjectId());
		executiondata.put(TestLinkParams.PARENT_ID.toString(), requirmentSpecification.getparentId());
		executiondata.put(TLParams.DOCUMENT_ID.toString(), requirmentSpecification.getDocumentId());
		executiondata.put(TestLinkParams.TITLE.toString(), requirmentSpecification.getTitle());
		executiondata.put(TLParams.SCOPE.toString(), requirmentSpecification.getScope());
		executiondata.put(TLParams.COUNT_REQ.toString(), requirmentSpecification.getcountReq());
		executiondata.put(TLParams.USER_ID.toString(), requirmentSpecification.getuserId());
		executiondata.put(TLParams.TYPE.toString(), requirmentSpecification.getType());
		executiondata.put(TestLinkParams.ORDER.toString(), requirmentSpecification.getOrder());
		executiondata.put(TestLinkParams.ACTION_ON_DUPLICATED_NAME.toString(), 
						requirmentSpecification.getActionOnDuplicate() != null ? requirmentSpecification.getActionOnDuplicate().toString(): null);
		
		return executiondata;
	}
}
