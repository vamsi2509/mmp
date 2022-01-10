package mmtestcases;


import org.testng.annotations.Test;

import library.BaseClass;
import mmpages.MMLoanAppPage2;



public class LoanApplyTC3 extends BaseClass {
	MMLoanAppPage2 mmlp2;
	@Test
	public void lApply() throws InterruptedException
	{
	mmlp2=new MMLoanAppPage2(driver);
	mmlp2.loanFormFill();
	}
	}


