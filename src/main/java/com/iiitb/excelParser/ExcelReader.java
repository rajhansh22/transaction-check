package com.iiitb.excelParser;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import com.iiitb.controller.UploadController;
import com.iiitb.model.Transaction;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ExcelReader {
    public static final String SAMPLE_XLSX_FILE_PATH = "/home/kishore/Documents/workspace-spring-tool-suite-4-4.1.1.RELEASE/transaction-check/data/";
    HashMap<Integer,String> map = new HashMap<Integer,String>();//make mapping of all and compulsory at some other places
    //public static void main(String[] args) throws IOException, InvalidFormatException {
    public List<Transaction> parse() throws IOException, InvalidFormatException, ParseException {
    	//int[] compulsoryColIds = new int[]{1,2,3,4,5,6,7,8 };
    	ArrayList<Integer> compulsoryColIds = new ArrayList<Integer>();
		for(int i=1;i<=8;i++)compulsoryColIds.add(i);
    	List<Transaction> transactions = new ArrayList<>();
    	File file = new File(SAMPLE_XLSX_FILE_PATH);
		File[] files = file.listFiles();
		for(File f: files){
			String current = f.getName();
			//System.out.println(current);
	        // Creating a Workbook from an Excel file (.xls or .xlsx)
			Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH+"/"+current));    	
	
	        Sheet sheet = workbook.getSheetAt(0);
	
	        // Create a DataFormatter to format and get each cell's value as String
	        DataFormatter dataFormatter = new DataFormatter();
	
	        //System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
	        
	        int i=0;
	        boolean flag=false;
	        SimpleDateFormat date1=null,date2=null;
	        flag=false;
	        for (Row row: sheet) {
	        	//System.out.println("New row scanning");
	        	if(!flag) {
            		flag=true;
            		continue;
            	}
	        	if(row.getPhysicalNumberOfCells()<=0)continue;
	        	//System.out.print("ROW VAL:"+);
	        	String dataVal[]=new String[16];
	        	i=0;
	        	boolean leave=false;
	            for(Cell cell: row) {
	                String cellValue = dataFormatter.formatCellValue(cell);
	                dataVal[i++]=cellValue;
	                if(compulsoryColIds.contains(i) && cellValue.equals("")) {
	                	System.out.println("Important data missing with id :"+dataVal[0]);
	                	leave=true;
	                	//break;
	                }
	                //System.out.print(i+":"+cellValue + "\t");
	            }
	            //System.out.println();
	            if(dataVal[0].trim().equals(""))break;
	            Transaction transaction=null;
	            if(leave) {
	        		transaction=new Transaction(dataVal[0],Double.parseDouble(dataVal[1]),dataVal[2],Double.parseDouble(dataVal[3]),Double.parseDouble(dataVal[4]),dataVal[5],dataVal[6],dataVal[7],
			        		"",dataVal[9],dataVal[10],0,0,0,0,0,true);
	        		transactions.add(transaction);
	        		continue;
	        	}
	            String session="";
	            java.util.Date d1=new Date(dataVal[2]);
	            SimpleDateFormat mFormat = new SimpleDateFormat("MM");
	            SimpleDateFormat yFormat = new SimpleDateFormat("yyyy");
	            String s=yFormat.format(d1).substring(2);
	            
	            if(Integer.parseInt(mFormat.format(d1))>3) {
	            	session=yFormat.format(d1).substring(2) + "-" + String.valueOf(Integer.parseInt(s)+1);
	            }
	            else {
	            	session=String.valueOf(Integer.parseInt(s)-1) + "-" + s;
	            }
	            
	            //java.util.Date d2=new Date(dataVal[10]);
	            
	            //date1=new SimpleDateFormat("dd/MM/yyyy");
	            //date2=new SimpleDateFormat("dd/MM/yyyy");
	            
	            //System.out.println("KUNAL :"+new SimpleDateFormat("dd/MM/yyyy").format(d1));
		        //date2=new SimpleDateFormat("MM/dd/yyyy").parse(dataVal[10]);
	        	
	        	
	        	
	        	double totalValue=Double.parseDouble(dataVal[1])/1.18;
	        	double admissionFee=totalValue-Double.parseDouble(dataVal[4]);
	        	double igst=Double.parseDouble(dataVal[1])-totalValue;
	        	double sgst=igst/2;
	        	double cgst=igst/2;
	        	
	        	transaction=new Transaction(dataVal[0],Double.parseDouble(dataVal[1]),dataVal[2],Double.parseDouble(dataVal[3]),Double.parseDouble(dataVal[4]),dataVal[5],dataVal[6],dataVal[7],
		        		session,dataVal[9],dataVal[10],cgst,sgst,igst,admissionFee,totalValue,false);
	        	
		        transactions.add(transaction);
		        //System.out.println(transaction.getPaymentId()+" added to list");
	        }
	        
	        
	        workbook.close();
	        Boolean b=f.delete();
	        if(b)System.out.println(current + " file deleted");
	        else System.out.println(current + " not file deleted");
	    }
		return transactions;
    }
}
