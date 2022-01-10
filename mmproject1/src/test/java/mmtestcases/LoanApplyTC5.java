package mmtestcases;


import org.testng.annotations.Test;
import library.BaseClass;
import mmpages.MMLoanAppPage4;

public class LoanApplyTC5 extends BaseClass {
	
	MMLoanAppPage4 mmlp4;
	@Test
	public void lApply() throws InterruptedException
	{
		
			mmlp4=new MMLoanAppPage4(driver);
			mmlp4.loanFormFill();
		
	}
}


