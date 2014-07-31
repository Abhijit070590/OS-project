package Beans;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ProcessTable {

	static String []in=new String[20];
	static String [][]index=new String[20][20];
	static int[] processcolom=new int[10];
	


	
	public static String[] getIn() {
	return in;
}


public static void setIn(String[] in) {
	ProcessTable.in = in;
}


public static String[][] getIndex() {
	return index;
}


public static void setIndex(String[][] index) {
	ProcessTable.index = index;
}


public static int[] getProcesscolom() {
	return processcolom;
}


public static void setProcesscolom(int[] processcolom) {
	ProcessTable.processcolom = processcolom;
}

}
	