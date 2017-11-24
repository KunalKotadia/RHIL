package com.aqm.testlink.Dataupaload;

import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.*; 

public final class MapField {
	private Map<String , Field> MappingRecord = new HashMap<String, Field>();
	private String[] FieldValue = new String[3];
	private boolean CoustomColumn;
	
	public Map<String, Field> getMapedField() throws Exception{
		File srcfile = new File("D:\\Users\\AQM Temp\\Downloads\\TestLinkUploader\\001_TestSuiteXMLGeneratorConfigurations.xlsx");
		FileInputStream fis = new FileInputStream(srcfile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
			for (int j = 1; j < sheet1.getRow(i).getLastCellNum(); j++) {
				if (j==4) {
					CoustomColumn = sheet1.getRow(i).getCell(j).getBooleanCellValue();
				}else {
					FieldValue[j-1] = sheet1.getRow(i).getCell(j).getStringCellValue();
				}
			}
			MappingRecord.put(FieldValue[1], new Field(FieldValue[0], FieldValue[1], FieldValue[2], CoustomColumn));
		}
		//System.out.println(sheet1.getLastRowNum());
		wb.close();
		return MappingRecord;
	}
}
