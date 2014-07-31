package Controller;


import javax.swing.JOptionPane;

import View.SplitPane;

	public class ChkExistPage {

		public static void pageexist(String phyadd,int line)
		{
			String des,src;
			boolean status;
			boolean chk=LoadPageTable.exist(phyadd);
			if(chk)
			{
				JOptionPane.showMessageDialog(null, "Page exist");
			}	
			else
			{
				JOptionPane.showMessageDialog(null, "Page not exist...Page Fault");
				// Checking weather MM is full or not
				status=AvailMem.available();
				if(status)
				{
					PageReplace.pagereplace();
				}
			// Bringing frame from SM to MM
				try {
					 des="/home/paras/Desktop/main_mem/"+phyadd;
					 src="/home/paras/Desktop/sec_mem/"+phyadd;
					SwapInPage.copy(src,des);
					LoadPageTable.updatePageTable(phyadd);
					JOptionPane.showMessageDialog(null, "Transfer from SM to MM");
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Exception");
					e.printStackTrace();
				}
			}
			
			
			// print desired data for the user
			try {
				ExecuteProcess.execute(line, phyadd);
				SplitPane sp=new SplitPane();
				sp.run(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				  JOptionPane.showMessageDialog(null, "Execution of Process problem");
				e.printStackTrace();
			}
		}
		
		
		
	}



