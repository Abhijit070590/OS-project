package Controller;





public class MapRequest {

	public static void mapping(int processno,int processline)
	{
		int frame;
	    boolean status=ReqValidation.validate(processno,processline);
		if(status==true)
		{
			if(processline%5==0)
			{
				frame=processline/5-1;
			}
			else
			{
				frame=processline/5;
			}
			String physicaladd = LoadProcessTable.index[processno-1][frame];
		//	JOptionPane.showMessageDialog(null, "Physical Adrs is :: "+physicaladd);
			ChkExistPage.pageexist(physicaladd,processline);
			}
	   	}
}
