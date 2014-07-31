package Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class LoadProcessTable {
	public static String []in=new String[20];
	static String [][]index=new String[20][20];
	public static int[] processcolom=new int[10];
	
	public static void load(int pnum)
	{
		int count=0;
		File folder = new File("/home/paras/Desktop/crawl_html");
		File[] name=folder.listFiles();
		ArrayList<String> listoffiles = new ArrayList<String>();
		for(File item : name)
		{
			if(item.isFile())
			{
				listoffiles.add(item.getName());
				count++;
			}
		}
		ArrayList<Integer> filenumber=new ArrayList<Integer>();
		for(String i: listoffiles )
			filenumber.add(Integer.parseInt(i.substring (3, i.length())));
		 Collections.sort(filenumber);
	    listoffiles.clear();
		for(Integer i:filenumber)
			listoffiles.add("pro"+i);
			
			
		// this array will store number of pages per process
			processcolom[pnum]=count;
		count=0;
		int put=0;
		for(String item : listoffiles)
		{
			index[pnum][put]=item;
			put++;
		}
		
	} 
	
}


