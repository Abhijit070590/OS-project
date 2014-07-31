package Controller;


import java.io.File;
import javax.swing.JOptionPane;

public class PageReplace {
	
	public static void pagereplace()
	{
		  String random=null;
		  int i=LoadPageTable.minimum();
		  random="pro"+i;
			JOptionPane.showMessageDialog(null, "Replaced Page is ::"+random);
			String src = "/home/paras/Desktop/main_mem/"+random;
			String des = "/home/paras/Desktop/sec_mem/"+random;
			try {
				SwapInPage.copy(src,des);
				 File f=new File(src);
				  if(f.exists())
					  f.delete();
				LoadPageTable.updatePageTable1(random);
		        JOptionPane.showMessageDialog(null, "Transfer from MM to SM");
		        //JOptionPane.showMessageDialog(null, "", "TransferringFile", JOptionPane.INFORMATION_MESSAGE, icon);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			 
		}
		



}
