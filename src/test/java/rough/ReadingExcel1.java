package rough;

import utils.Xls_Reader;

public class ReadingExcel1 {

	public static void main(String[] args) {
 
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//src//test//resources//RoughExcel.xlsx");
		
		String sheetName= "TestData";
		
		String testName=  "OpenAccountTest";//AddCustomerTest OpenAccountTest
		
		int totalRows = xls.getRowCount(sheetName);
		System.out.println("Total Rows : " + totalRows);
		
		 int dataStartRow =1 ;
		 for ( dataStartRow = 1; dataStartRow<=totalRows; dataStartRow++ ) {
			 
			 if(testName.equalsIgnoreCase(xls.getCellData(sheetName, 0, dataStartRow))) 
				break;
			  
		 }
		 
		 System.out.println("test case name is at :" + dataStartRow);
		 
		 int testCaseStartRow= dataStartRow+2;
		 
		 int totalRowsTestCase= 0;
		 while(xls.getCellData(sheetName, 0, testCaseStartRow+totalRowsTestCase)!="") {
			 totalRowsTestCase++;
		 }
		 System.out.println("Data rows are: " + totalRowsTestCase);
		 
		 int totalColsTestCase= 0;
		 while(xls.getCellData(sheetName, totalColsTestCase, testCaseStartRow)!="") {
			 totalColsTestCase++;
		 }
		 System.out.println("Data rows are: " + totalColsTestCase);
		 
		 
		 for( int rows = testCaseStartRow; rows<( testCaseStartRow+totalRowsTestCase); rows++) {
			 
			 for ( int cols = 0; cols< totalColsTestCase;  cols++) {
				 
				 System.out.print(xls.getCellData(sheetName, cols, rows)+" ");
			 }
			 System.out.println();
		 }

	}

}
