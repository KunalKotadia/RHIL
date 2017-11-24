package com.aqm.testlink.Uploader;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.aqm.testlink.Dataupaload.TestlinkSetup;

public class TestlinkUploader extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Container c;
	private JTabbedPane jtp;
	private JPanel jpnl1, jpnl2;
	private Label label1, label2, label3, label4, label5;
	private JTextField tf1, tf2, tf3, tf4;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	private File file1, file2;
	private String path1, path2;
	private JFileChooser fc1, fc2;
	private TestlinkSetup tlsetup = new TestlinkSetup();
	private Cursor cur = new Cursor(Cursor.HAND_CURSOR);
	private Font fnt12 = new Font("Arial", Font.BOLD, 12);
	private Font fnt14 = new Font("Arial", Font.BOLD, 13);
	private String result; 
	
	public TestlinkUploader() {
		this.setTitle("Testlink Uploader");
		ImageIcon logo = new ImageIcon("D:\\Users\\AQM Temp\\eclipse-workspace\\Uploader\\src\\main\\java\\com\\aqm\\testlink\\Uploader\\testlinkicon.png");
		this.setIconImage(logo.getImage());
		c = this.getContentPane();
		c.setLayout(null);
		jtp = new JTabbedPane();
		jtp.setBounds(0, 0, 550, 200);
		jtp.setFont(fnt14);
		jpnl1 = new JPanel();
		jpnl1.setLayout(null);
		jpnl1.setBounds(0, 0, 550, 200);
		jpnl2 = new JPanel();
		jpnl2.setLayout(null);
		jpnl2.setBounds(0, 0, 550, 200);
		
		label1 = new Label("Source Folder  : ");
		label1.setBounds(10, 0, 150, 30);
		label1.setFont(fnt12);
		label2= new Label("Select Soure Repo File  : ");
		label2.setBounds(10, 35, 150, 30);
		label2.setFont(fnt12);
		label3 = new Label("URL  : ");
		label3.setBounds(10, 0, 150, 30);
		label3.setFont(fnt12);
		label4 = new Label("Dev Key  : ");
		label4.setBounds(10, 35, 150, 30);
		label4.setFont(fnt12);
		label5 = new Label("Connection Not Established");
		label5.setBounds(160, 105, 157, 30);
		label5.setFont(fnt12);
		
		tf1 = new JTextField();
		tf1.setBounds(160, 0, 300, 30);
		tf1.setEditable(false);
		tf2 = new JTextField();
		tf2.setBounds(160, 35, 300, 30);
		tf2.setEditable(false);
		tf3 = new JTextField();
		tf3.setBounds(160, 0, 300, 30);
		tf4 = new JTextField();
		tf4.setBounds(160, 35, 300, 30);
		
		btn1 = new JButton("...");
		btn1.setBounds(470, 0, 30, 30);
		btn1.addActionListener(this);
		btn2 = new JButton("...");
		btn2.setBounds(470, 35, 30, 30);
		btn2.addActionListener(this);
		btn3 = new JButton("Upload");
		btn3.setBounds(380, 70, 80, 30);
		btn3.setCursor(cur);
		btn3.addActionListener(this);
		btn4 = new JButton("Connect"); 
		btn4.setBounds(370, 70, 90, 30);
		btn4.addActionListener(this);
		btn4.setCursor(cur);
		btn5 = new JButton("Refresh");
		btn5.setBounds(270, 70, 90, 30);
		btn5.addActionListener(this);
		btn5.setCursor(cur);
		btn6 = new JButton("Disconnect");
		btn6.setBounds(270, 70, 100, 30);
		btn6.addActionListener(this);
		btn6.setCursor(cur);
		
		jpnl2.add(label1);
		jpnl2.add(tf1);
		jpnl2.add(btn1);
		jpnl2.add(label2);
		jpnl2.add(tf2);
		jpnl2.add(btn2);
		jpnl2.add(btn3);
		jpnl2.add(btn6);
		jpnl1.add(label3);
		jpnl1.add(tf3);
		jpnl1.add(label4);
		jpnl1.add(tf4);
		jpnl1.add(btn4);
		jpnl1.add(btn5);
		
		jtp.add("Connection", jpnl1);
		jtp.add("Repo. Uploader", jpnl2);
		jtp.setEnabledAt(1, false);
		c.add(jtp);
    }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1) {
			fc1 = new JFileChooser();
			fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (file1 != null) {
				fc1.setCurrentDirectory(file1);
			}
			int i = fc1.showOpenDialog(this);
			if(i == JFileChooser.APPROVE_OPTION) {
				file1 = fc1.getSelectedFile();
				path1 = file1.getPath();
				tf1.setText(path1);
			}
		}
		if(e.getSource()== btn2) {
			fc2=new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsb");
			fc2.setFileFilter(filter);
			fc2.setCurrentDirectory(file1);
			fc2.setAcceptAllFileFilterUsed(false);
			int i = fc2.showOpenDialog(this);
			if(i == JFileChooser.APPROVE_OPTION) {
				file2 = fc2.getSelectedFile();
				path2 = file2.getPath();
				tf2.setText(path2.replace("\\", "/").replaceAll(path1.replace("\\", "/"), "").replace("/", "\\"));
			}
		}
		if(e.getSource() == btn3) {
			if(tlsetup.uploadData(path1, path2).equals("DONE")) {
				JOptionPane.showMessageDialog(null, "Successfully Uploaded");
			}else {
				System.out.println("Uploading failed");
			}
		}
		if(e.getSource()==btn4) {
			if(tlsetup.connection("http://localhost:81/testlink/lib/api/xmlrpc/v1/xmlrpc.php", "6af8fa99d152c0dc38df8f7a0253d32b")) {
				jtp.setEnabledAt(1, true);
				jtp.setEnabledAt(0, false);
				jtp.setSelectedIndex(1);
			}else {
				jpnl1.add(label5);
			}
		}
		if(e.getSource()==btn5) {
			jpnl1.remove(label5);
			tf3.setText("");
			tf4.setText("");
		}
		if(e.getSource() == btn6) {
			if(tlsetup.connection(tf3.getText() + "/disconnect", tf4.getText() + "/disconnect")){
				
			}else {
				jtp.setEnabledAt(1, false);
				jtp.setEnabledAt(0, true);
				jtp.setSelectedIndex(0);
				jpnl1.remove(label5);
			}
		}
	}
}