package Controller;


public class ReqValidation {
	
	public static boolean validate(int processno, int processline)
	{
	 if(processline==0)
	    {
	    	return false;
	    }
		 if(processno<=SplitProcess.process)
		    {
		    	if(processline<=SplitProcess.lines[processno-1])
		    	{
		    		return true;
			    	
		    	}
		    	else
		    	{
		    		return false;
		    	}
		    }
		    else
		    {
		    	return false;
		    }

	}

}
