package mmtestcases;


import org.testng.annotations.Test;
import library.BaseClass;
import mmpages.MMLoanAppPage3;

public class LoanApplyTC4 extends BaseClass{
	
	MMLoanAppPage3 mmlp3;
	
	@Test
	public void lApply() throws InterruptedException
	{
			mmlp3=new MMLoanAppPage3(driver);
			mmlp3.loanFormFill();
		
	}
	}


