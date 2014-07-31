package Controller;

public class LoadPageTable {

	public static String []pageTable=new String[99];
	public static int[] pageRAV=new int[100];
	static int pageTableCounter=1;
	static int Frame_counter=0;
	static int count=1,count1=1;
	public static void load()
	{
		pageTable[pageTableCounter]="NOFRAME";      
		pageTableCounter++;
	}
	// SM to MM transfer time
	public static void updatePageTable(String phyAdrs)
	{
		int i;
		Frame_counter++;
		i=Integer.parseInt((String)phyAdrs.subSequence(3, phyAdrs.length()));
		pageTable[i]="FRAME"+count;
		pageRAV[i]=count1;
		count++;
		count1++;
	}
	// MM to SM transfer time
	
	public static void updatePageTable1(String phyAdrs)
	{
		int i;
		String freeFrame;
		Frame_counter--;
		i=Integer.parseInt((String)phyAdrs.subSequence(3, phyAdrs.length()));
		freeFrame=pageTable[i];
		count=Integer.parseInt((String)freeFrame.subSequence(5, freeFrame.length()));
		pageTable[i]="NOFRAME";
	}
	
	public static int minimum()
	{
		int min=0,value=100;
		for(int i=0;i<100;i++)
		{
			if(pageRAV[i]!=0 && pageRAV[i]<value)
			{
				min=i;
				value=pageRAV[min];
			}
		}
		pageRAV[min]=0;
		return min;
	}
	
	public static boolean exist(String phyAdrs)
	{

		boolean status=false;
		int i;
		i=Integer.parseInt((String)phyAdrs.subSequence(3, phyAdrs.length()));
		
			
			if(pageTable[i].equals("NOFRAME"))
			{
				status=false;
			}
			else
			{
				status=true;
			}
		
		return status;
	}
}
