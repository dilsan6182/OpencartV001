package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {
	
	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path=".\\testdata\\OpenCart_DataDriven.xlsx";      //taking excel file from testdata
		ExcelUtility xlutil= new ExcelUtility(path);             //creating an object for excelutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];   //created for two dimension array which can store 
		
		for(int i=1;i<=totalrows;i++) {                          //1     //read the data from excel storing in two dimension array
			for(int j=0;j<totalcols;j++) {                       //0        i is rows j is column
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);           //1,0 
			}
		}
		return logindata;           //returning two dimension array
	}
	
	//DataProvider2
	//Dataprovider3

}
