package Controller;


public class ProRequestHandler {

	public static void HandleReq(String adrs)
	{
		
		String[] str  = adrs.split(" ");
	    // Here i m assuming that a process is not greater than 99 lines...
		
	    int processline=Integer.parseInt(str[1]);
	    int processno=Integer.parseInt(str[0]);
	    MapRequest.mapping(processno,processline);
	}
}