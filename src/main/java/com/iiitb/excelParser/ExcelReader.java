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
import java.util.Date;
import java.util.List;

public class ExcelReader {
    public static final String SAMPLE_XLSX_FILE_PATH = "/home/kishore/Documents/workspace-spring-tool-suite-4-4.1.1.RELEASE/spring-boot-file-upload-example/data/";

    //public static void main(String[] args) throws IOException, InvalidFormatException {
    public List<Transaction> parse() throws IOException, InvalidFormatException, ParseException {
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
	        String dataVal[]=new String[16];
	        int i=0;
	        boolean flag=false;
	        SimpleDateFormat date1=null,date2=null;
	        flag=false;
	        for (Row row: sheet) {
	        	if(!flag) {
            		flag=true;
            		continue;
            	}
	        	i=0;
	            for(Cell cell: row) {
	                String cellValue = dataFormatter.formatCellValue(cell);
	                dataVal[i++]=cellValue;
	                //System.out.print(cellValue + "\t");
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
	            
	            //System.out.println("KUNAL :"+new SimpleDateFormat("dd/MM/yyyy").format(d));
		        //date2=new SimpleDateFormat("MM/dd/yyyy").parse(dataVal[10]);
	        	
	        	
	        	
	        	double totalValue=Double.parseDouble(dataVal[1])/1.18;
	        	double admissionFee=totalValue-Double.parseDouble(dataVal[4]);
	        	double igst=Double.parseDouble(dataVal[1])-totalValue;
	        	double sgst=igst/2;
	        	double cgst=igst/2;
		        Transaction transaction=new Transaction(dataVal[0],Double.parseDouble(dataVal[1]),dataVal[2],Double.parseDouble(dataVal[3]),Double.parseDouble(dataVal[4]),dataVal[5],dataVal[6],dataVal[7],
		        		session,dataVal[9],dataVal[10],cgst,sgst,igst,admissionFee,totalValue);
		        transactions.add(transaction);
		        //UploadController.transactionrepo.save(transaction);
		        System.out.println();
	        }
	        
	        
	        workbook.close();
	        Boolean b=f.delete();
	        if(b)System.out.println(current + "file deleted");
	        else System.out.println(current + "not file deleted");
	    }
		return transactions;
    }
}
