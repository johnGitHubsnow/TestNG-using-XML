package TestNG.testngProject;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[4][2];
		
		data[0][0] = "mngr433776";
		data[0][1] = "ArEjAvy";
		
		data[1][0] = "mngr433784";
		data[1][1] = "gUtuhUn";
		
		data[2][0] = "mngr433786";
		data[2][1] = "umanEta";
		
		data[3][0] = "mngr433788";
		data[3][1] = "YjArAme";
		
		
		
		return data;
		
	}

}
