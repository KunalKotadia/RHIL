package com.aqm.testlink.ModifiedTestLinkJavaApi.model;

import java.io.Serializable;

import br.eti.kinoshita.testlinkjavaapi.constants.ActionOnDuplicate;

public class RequirmentSpecification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer testProjectId;
	private Integer parentId;
	private String documentId;
	private String title;
	private String scope;
	private static Integer countReq;
	private String userId;
	private String type;
	private Integer order;
	private ActionOnDuplicate actionOnDuplicate;
	
	public RequirmentSpecification(Integer testProjectId, Integer parentId,String documentId, String title,
            					   String scope, Integer countReq, String userId, String type, ActionOnDuplicate actionOnDuplicate) {
		this.testProjectId = testProjectId;
		this.parentId = parentId;
		this.documentId = documentId;
		this.title = title;
		this.scope = scope;
		RequirmentSpecification.countReq = countReq;
		this.userId = userId;
		this.type = type;
		this.order = order;
		this.actionOnDuplicate = actionOnDuplicate;		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer gettestProjectId() {
		return testProjectId;
	}
	public void settestProjectId(Integer projectid) {
		this.testProjectId = projectid;
	}
	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public Integer getparentId() {
		return parentId;
	}
	public void setparentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Integer getcountReq() {
		return countReq;
	}
	public void setcountReq(Integer countReq) {
		RequirmentSpecification.countReq = countReq;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public ActionOnDuplicate getActionOnDuplicate() {
		return actionOnDuplicate;
	}
	public void setActionOnDuplicate(ActionOnDuplicate actionOnDuplicate) {
		this.actionOnDuplicate = actionOnDuplicate;
	}
}