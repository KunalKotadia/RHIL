package com.aqm.testlink.Dataupaload;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

//import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aqm.testlink.ModifiedTestLinkJavaApi.TLApi;
import com.aqm.testlink.ModifiedTestLinkJavaApi.model.RequirmentSpecification;

import br.eti.kinoshita.testlinkjavaapi.*;
import br.eti.kinoshita.testlinkjavaapi.constants.ActionOnDuplicate;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.constants.TestCaseStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.TestImportance;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestSuite;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class TestlinkSetup {
	private TLApi tlapi;
	
	public boolean connection(String url, String Devkey) {
		URL Url = null;
		try {
			Url = new URL(url);
		}catch(MalformedURLException mue) {
			mue.printStackTrace();
		}
		
		try {
			tlapi = new TLApi(Url, Devkey);
			return true;
		}catch(TestLinkAPIException tle) {
			return false;
		}
	}
	
	public String uploadData(String DirPath, String ExcelFilePath) {
		final String[] uploadedSheets = new String[] {"Business Function", "Business Processes", "Business Scenarios", "Test Cases"};
		File src = new File(ExcelFilePath.replace("\\", "\\\\"));
		FileInputStream fis = null;
		String tempStr = ExcelFilePath.replace("\\", "/").replaceAll(DirPath.replace("\\", "/"), "").replace("/", "\\");
		String TSuiteName = tempStr.substring(1, tempStr.indexOf("\\", 1));
		int TPId = tlapi.getTestProjectByName("MyFirstProject 001").getId();
		TestSuite TS = null;
		RequirmentSpecification[] requirmentSpecification = new RequirmentSpecification[2];
		TestCase[] TC = null;
		CheckConfigExcelFile check = null;
		XSSFWorkbook xssfwb = null;
		XSSFSheet xssfsheet = null;
		try{
			fis = new FileInputStream(src);
			if(ExcelFilePath.substring(ExcelFilePath.lastIndexOf(".")+1, ExcelFilePath.length()).equals("xlsx")) {
				xssfwb = new XSSFWorkbook(fis);
				check = new CheckConfigExcelFile(xssfwb);
				//TS = tlapi.createTestSuite(TPId, TSuiteName, "Details of " + TSuiteName, null, null, true, ActionOnDuplicate.BLOCK);
				requirmentSpecification[0] = tlapi.createRequirmentSpecification(TPId, null, "gaklfgfs", "fhbaf", "sdfgsdf", null, "nikhilv", null, ActionOnDuplicate.BLOCK);
				requirmentSpecification[1] = tlapi.createRequirmentSpecification(TPId, null, "gaklfsdfgfs", "fhbsdfaf", "sdfsdfgsdf", null, "nikhilv", null, ActionOnDuplicate.BLOCK);
				/*System.out.println(requirmentSpecification.getId());
				System.out.println(requirmentSpecification.getDocumentId());
				System.out.println(requirmentSpecification.getTitle());
				System.out.println(requirmentSpecification.getScope());
				System.out.println(requirmentSpecification.getparentId());
				System.out.println(requirmentSpecification.getActionOnDuplicate().toString());*/
				
				/*for (int i = 0; i < 4; i++) {
					xssfsheet = xssfwb.getSheet(uploadedSheets[i]);
					for (int j = 1; j <= xssfsheet.getLastRowNum()-850; j++) {
						if(xssfsheet.getSheetName().equals(uploadedSheets[0]) && check.isBFCorrectlyMapped()) {
							
						}
						if(xssfsheet.getSheetName().equals(uploadedSheets[1]) && check.isBPCorrectlyMapped()) {
							
						}
						if(xssfsheet.getSheetName().equals(uploadedSheets[2]) && check.isScenarioCorrectlyMapped()) {
							
						}
						if(xssfsheet.getSheetName().equals(uploadedSheets[3]) && check.isTestCaseCorrectlyMapped()) {
							if (TC == null) {
								TC = new TestCase[xssfsheet.getLastRowNum()];
							}
							TC[j-1] = tlapi.createTestCase("TC "+j, TS.getId(), TPId, "nikhilv", xssfsheet.getRow(j).getCell(10).getStringCellValue(), null, xssfsheet.getRow(j).getCell(13).getStringCellValue(), TestCaseStatus.FINAL, TestImportance.HIGH, ExecutionType.MANUAL, null, null, true, ActionOnDuplicate.BLOCK);
							for (int j2 = 0; j2 < xssfsheet.getRow(0).getLastCellNum(); j2++) {
								if(check.isCustomField(xssfsheet.getRow(0).getCell(j2).getStringCellValue())) {
									if(xssfsheet.getRow(0).getCell(j2).getStringCellValue().equals("Test Case Creation Date")) {
										tlapi.updateTestCaseCustomFieldDesignValue(TC[j-1].getId(), TC[j-1].getVersion(), TPId, xssfsheet.getRow(0).getCell(j2).getStringCellValue(), xssfsheet.getRow(j).getCell(j2).getDateCellValue().toString());
									}else {
										tlapi.updateTestCaseCustomFieldDesignValue(TC[j-1].getId(), TC[j-1].getVersion(), TPId, xssfsheet.getRow(0).getCell(j2).getStringCellValue(), xssfsheet.getRow(j).getCell(j2).toString());
									}	
								}
							}
							System.out.println(TC[j-1].getName());							
						}
					}
				}*/
				xssfwb.close();
				//return "DONE";
			}/*else {
				HSSFWorkbook hssfwb = new HSSFWorkbook(fis);
				System.out.println(hssfwb.getNumberOfSheets());
				//return "FAILED";
			}*/
			return "DONE";
		}catch(Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
	}
}
