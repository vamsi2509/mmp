package mmtestcases;


import org.testng.annotations.Test;

import library.BaseClass;
import mmpages.MMHomePage;

public class LoanApplyTC extends BaseClass {
	

	MMHomePage mmh;
	
	@Test
	public void lApply()
	{
	mmh=new MMHomePage(driver);	
	mmh.applyloan();
	}
}


