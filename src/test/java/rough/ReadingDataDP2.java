package rough;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Xls_Reader;

public class ReadingDataDP2 {

	 
	@Test(dataProvider="get")
	public void testA(Hashtable<String, String> table) {
		
		//System.out.println(table.get("Runmode") +"--"+ table.get("firstname")  +"--"+ table.get("lastname")  +"--"+table.get("postcode"));
		System.out.println(table.get("Runmode") +"--"+ table.get("customer")  +"--"+ table.get("currency"));
	}
 
	
	
	@DataProvider(name="get")
	public Object[][]fetch() {
		
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
		 int testColumnName = dataStartRow+1;
		 while(xls.getCellData(sheetName, totalColsTestCase, testColumnName)!="") {
			 totalColsTestCase++;
		 }
		 System.out.println("Data rows are: " + totalColsTestCase);
		 
		// Object[][] data = new Object[totalRowsTestCase][totalColsTestCase];
		 
		 
		 
		 Object[][] data = new Object[totalRowsTestCase][1];
		 
		 int i= 0;
		 for( int rows = testCaseStartRow; rows<( testCaseStartRow+totalRowsTestCase); rows++) {
			 
			 Hashtable<String, String> table = new Hashtable<>();
			 
			 for ( int cols = 0; cols< totalColsTestCase;  cols++) {
				 
				// System.out.print(xls.getCellData(sheetName, cols, rows)+" ");
				// data[rows-testCaseStartRow][cols] = xls.getCellData(sheetName, cols, rows);
				 
				 String testData = xls.getCellData(sheetName, cols, rows);
				 String colNames = xls.getCellData(sheetName, cols, testColumnName );
				 
				 table.put(colNames, testData);
			 }
			 data[i][0]  = table;
			 i++;
		 }

		
		return data;
	}
	
}
