package com.aqm.testlink;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.aqm.testlink.Dataupaload.*;
import com.aqm.testlink.ModifiedTestLinkJavaApi.TLApi;
import com.aqm.testlink.Uploader.TestlinkUploader;

public class App {	
	
    public static void main( String[] args ){
    	TestlinkUploader tlup = new TestlinkUploader();
    	tlup.setVisible(true);
    	tlup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	tlup.setBounds(200, 200, 550, 200);
    	tlup.setResizable(false);
    	/*TestlinkSetup tlsetup = new TestlinkSetup();
    	tlsetup.uploadData();*/
    	/*MapField mf = new MapField();
    	Map<String, Field> map = null;
    	try {
    		map = mf.getMapedField();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println();*/
    	/*CheckConfigExcelFile check = new CheckConfigExcelFile();
    	check.isBFCorrectlyMapped();*/
    	
    }
}
