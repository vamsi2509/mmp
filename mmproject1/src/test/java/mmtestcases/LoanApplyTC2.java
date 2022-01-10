package mmtestcases;

import org.testng.annotations.Test;
import library.BaseClass;
import mmpages.MMLoanAppPage1;

public class LoanApplyTC2 extends BaseClass{
	
	MMLoanAppPage1 mmlp1;
	
	
	@Test
	public void lApply() throws InterruptedException
	{
			mmlp1=new MMLoanAppPage1(driver);
			mmlp1.loanFormFill();
		
	}
	
}


