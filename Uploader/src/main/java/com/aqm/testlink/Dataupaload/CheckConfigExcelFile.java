package com.aqm.testlink.Dataupaload;

import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class CheckConfigExcelFile {

	private Map<String, Field> ConfigExcelFile;
	private XSSFWorkbook xssfwb;
	private MapField map;
	
	public CheckConfigExcelFile(XSSFWorkbook xssfwb) {
		this.xssfwb = xssfwb;
		map = new MapField();
		try {
			ConfigExcelFile = map.getMapedField();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isBFCorrectlyMapped() {
		final String[] BFFieldMappedInTL = new String[]{"Document ID", "Title", "Scope", "Importance", "Status", "Reference Source Document", "Remark"};
		XSSFSheet xssfsheet = this.xssfwb.getSheetAt(1);
		int flagup = 0;
		for (int i = 0; i < BFFieldMappedInTL.length; i++) {
			if(ConfigExcelFile.get(xssfsheet.getRow(0).getCell(i).getStringCellValue()).getTestlinkFieldName().equals(BFFieldMappedInTL[i])) {
				flagup++;
			}
		}
		if(flagup == BFFieldMappedInTL.length) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isBPCorrectlyMapped() {
		final String[] BPFieldMappedInTL = new String[]{"Link", "Document ID", "Title", "Scope", "Importance", "Status", "Reference Source Document", "Remarks"};
		XSSFSheet xssfsheet = this.xssfwb.getSheetAt(2);
		int flagup = 0;
		for (int i = 0; i < BPFieldMappedInTL.length; i++) {
			if(ConfigExcelFile.get(xssfsheet.getRow(0).getCell(i).getStringCellValue()).getTestlinkFieldName().equals(BPFieldMappedInTL[i])) {
				flagup++;
			}else {
			}
		}
		if(flagup == BPFieldMappedInTL.length) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isScenarioCorrectlyMapped() {
		final String[] ScenarioFieldMappedInTL = new String[]{"Link", "Link", "Document ID", "Product Name", "BP Module", "Title", "Scope", "Category", "SCN Importance", "Type", "Identified By", "Status"};
		XSSFSheet xssfsheet = this.xssfwb.getSheetAt(3);
		int flagup = 0;
		for (int i = 0; i < ScenarioFieldMappedInTL.length; i++) {
			if(ConfigExcelFile.get(xssfsheet.getRow(0).getCell(i).getStringCellValue()).getTestlinkFieldName().equals(ScenarioFieldMappedInTL[i])) {
				flagup++;
			}
		}
		if(flagup == ScenarioFieldMappedInTL.length) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isTestCaseCorrectlyMapped() {
		final String[] TCFieldMappedInTL = new String[]{"Test Case ID", "Test Case Title", "Test Case Creation Date", "Prepared By", "Link", "TC Product Name", "TC Module", "Keywords", "TC Sub-Module", "Path", "Summary", "Test Steps", "Test Criteria", "Preconditions", "Test Priority", "Test Classification", "Test Case Complexity", "Test Data", "Expected Output", "Test Category", "Status", "Importance"};
		XSSFSheet xssfsheet = this.xssfwb.getSheetAt(4);
		int flagup = 0;
		for (int i = 0; i < TCFieldMappedInTL.length; i++) {
			if(ConfigExcelFile.get(xssfsheet.getRow(0).getCell(i).getStringCellValue()).getTestlinkFieldName().equals(TCFieldMappedInTL[i])) {
				flagup++;
			}
		}
		if(flagup == TCFieldMappedInTL.length) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isCustomField(String Field) {
		if(ConfigExcelFile.get(Field).isCustomColumn()) {
			return true;
		}else {
			return false;
		}
	}
}
