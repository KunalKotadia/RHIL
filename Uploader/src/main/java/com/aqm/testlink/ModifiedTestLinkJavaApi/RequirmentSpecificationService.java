package com.aqm.testlink.ModifiedTestLinkJavaApi;

import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

import com.aqm.testlink.ModifiedTestLinkJavaApi.constant.TLMethods;
import com.aqm.testlink.ModifiedTestLinkJavaApi.map.Mapping;
import com.aqm.testlink.ModifiedTestLinkJavaApi.model.RequirmentSpecification;

import br.eti.kinoshita.testlinkjavaapi.constants.ActionOnDuplicate;
import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkResponseParams;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import br.eti.kinoshita.testlinkjavaapi.util.Util;

@SuppressWarnings("unchecked")
class RequirmentSpecificationService extends BaseService{
	
	public RequirmentSpecificationService(XmlRpcClient xmlRpcClient, String devKey) {
		super(xmlRpcClient, devKey);
		// TODO Auto-generated constructor stub
	}

	public RequirmentSpecification createRequirmentSpecification(Integer testProjectId, Integer parentId,String documentId, String title,
            String scope, Integer countReq, String userId, String type, /*Integer order,*/ ActionOnDuplicate actionOnDuplicate) throws TestLinkAPIException{
		
		RequirmentSpecification requirmentSpecification = new RequirmentSpecification(testProjectId, parentId, documentId, title, scope, countReq, userId, type, /*order,*/ actionOnDuplicate);
		Integer id = null;
		
		try {
			Map<String, Object> executiondata = Mapping.getRequirementSpecificationMap(requirmentSpecification);
			Object response = this.executeXmlRpcCall(TLMethods.CREATE_REQUIREMENT_SPECIFICATION.toString(), executiondata);
			Object[] responseArray = Util.castToArray(response);
			Map<String, Object> responseMap = (Map<String, Object>) responseArray[0];
			id = Util.getInteger(responseMap, TestLinkResponseParams.ID.toString());
			requirmentSpecification.setId(id);
			//System.out.println(responseMap.get("message").toString());
			//System.out.println(responseMap.get("status").toString());
			//System.out.println(responseMap.get("flag").toString());
			
		} catch (XmlRpcException xmlrpcex) {
			throw new TestLinkAPIException("Error creating requirement spec: " + xmlrpcex.getMessage(), xmlrpcex);
		}
		return requirmentSpecification;
	}
}
