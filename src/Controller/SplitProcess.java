package Controller;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import View.SplitPane;



public class SplitProcess {

	public static int process=0;
	static int pnum=1;
	public static int[] lines=new int[50];
	static int VMsize=4;  // In form of number of pages it can accommodate
	
	
	
	public static void split(String inputProcess) throws Exception
	{
		final File mainDir = new File("/home/paras/Desktop/sec_mem");
		
		final File parentDir = new File("/home/paras/Desktop/crawl_html");
		parentDir.mkdir();

		int ind=0;
		String ary[]=new String[100];
		  int count=0;
		try{
			  // Open the file
			
			  String stream="/home/paras/Desktop/processes/";
			  
			  stream=stream+inputProcess;
			  FileInputStream fstream = new FileInputStream(stream);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // split the line on your splitter(s)
			  String[] splitted = strLine.split("\n"); // here - is used as the delimiter
			  ary[ind]=splitted[0];
			  ind++;
		      count++;
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){
			    	//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
		// Store number of lines per process
		lines[process]=count;
        int d=0;
        String name="pro";
        
        int e=0;
        while(d<count)
        {
        	String nn=name+pnum;
        	
        	File f=new File(parentDir, nn);
        	File fm=new File(mainDir, nn);
    		f.createNewFile();
    		fm.createNewFile();
    		PrintWriter pwm = new PrintWriter(new FileWriter(fm));
    		PrintWriter pw = new PrintWriter(new FileWriter(f));
        	for(int j=0;j<5 && e<ind;j++)
        	{
        		pwm.println(ary[d]);
        		pw.println(ary[d]);
        		d++;
        		e++;
        	}
        	LoadPageTable.load();
        	pw.close();
        	pwm.close();
        	pnum++;
        }
        
        LoadProcessTable.load(process);
        process++;
        // Delete crawl_html folder which is used for indes 2 D array
        
        final File[] fdel=parentDir.listFiles();
        for(File f:fdel)
        {
        	
        	f.delete();
        	
        }	
        parentDir.delete();
		
		
		SplitPane sp=new SplitPane();
		sp.run(null);
		
	}
}
