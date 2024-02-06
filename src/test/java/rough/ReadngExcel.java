package rough;

import utils.Xls_Reader;

public class ReadngExcel {

	public static void main(String[] args) {
		 
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//src//test//resources//RoughExcel.xlsx");
		
		int rows = xls.getRowCount("TestData");
		
		System.out.println("Total Rows: "+ rows);//9
		
		String testName ="OpenAccountTest";//AddCustomerTest OpenAccountTest
		
		int testCaseRowNum= 1;
		
	    for(testCaseRowNum= 1; testCaseRowNum<=rows; testCaseRowNum++) {
	    	
	      String testCaseName= xls.getCellData("TestData", 0, testCaseRowNum);
	       
	      if(testCaseName.equalsIgnoreCase(testName)) 
	        	break;
	        	
	  
	      }
	   
	    
	    System.out.println("testCaseRowNum: " + testCaseRowNum);
	    
	    int datastartrow = testCaseRowNum+ 2;
	    int rowNum= 0;
	    
	    while(xls.getCellData("TestData", 0,datastartrow+rowNum)!="") {
	    	
	    	
	    	rowNum++;
	    }
	     System.out.println("rowNum: " + rowNum);
	    
		 
	     int colCount= 0;
	     while (xls.getCellData("TestData", colCount,datastartrow+1)!="") {
	    	 colCount++;
	     }
	     
	     System.out.println("colCount: " + colCount);
	     
	     
	     for ( int rNum = datastartrow ; rNum<=(datastartrow+rowNum); rNum++ ) {
	    	 
	    	 for( int cNum= 0; cNum< colCount; cNum++) {
	    		 
	    		    
	    		 System.out.print(xls.getCellData("TestData", cNum, rNum)+ " ");
	    		 	
	    	 }
	    	 System.out.println();
	     }
	}

}
