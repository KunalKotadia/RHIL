package com.aqm.testlink.ModifiedTestLinkJavaApi;

import java.net.URL;
import com.aqm.testlink.ModifiedTestLinkJavaApi.model.RequirmentSpecification;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ActionOnDuplicate;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class TLApi extends TestLinkAPI {
	private RequirmentSpecificationService requirmentspecificationservice;
	//private RequirmentService requirmentservice;
	public TLApi(URL url, String devKey) throws TestLinkAPIException {
		super(url, devKey);
		this.requirmentspecificationservice = new RequirmentSpecificationService(this.getXmlRpcClient(), devKey);
		//this.requirmentservice = new RequirmentService(this.getXmlRpcClient(), devKey);
	}
	
	public RequirmentSpecification createRequirmentSpecification(Integer testProjectId, Integer parentId,String documentId, String title,
            String scope, Integer countReq, String userId, String type, ActionOnDuplicate actionOnDuplicate) {
        return this.requirmentspecificationservice.createRequirmentSpecification(testProjectId, parentId, documentId, title,
                scope, countReq, userId, type, actionOnDuplicate );
    }	
}
