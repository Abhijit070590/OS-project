package Controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ExecuteProcess {

	
	public static void execute(int line,String name) throws Exception
	{
		String []ary=new String[5];
		int ind=0;
		String file="/home/paras/Desktop/main_mem/"+name;
		
		 FileInputStream fstream = null;
		
			fstream = new FileInputStream(file);
		
		
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null) 
		  {
		  // split the line on your splitter(s)
		  String[] splitted = strLine.split("\n"); // here - is used as the delimiter
		  ary[ind]=splitted[0];
		  ind++;
		  }
		  
		  if(line%5!=0)
			  line=line%5;
		  else
			  line=5;
		 
		  JOptionPane.showMessageDialog(null, "ProcessData :: "+ary[line-1]);
		  
		
		
	}
}
