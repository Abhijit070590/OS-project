package Controller;


public class AvailMem {

	

	public  static boolean available()
	{
	
	// Here I am assuming that main memory has only 4 frames available
		if(LoadPageTable.Frame_counter>=4)
		{
			return true;
		}
		else
		{
			return false;
			
		}

	}

}