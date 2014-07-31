package Model;
import java.io.File;
import View.StartPro;

public class ProjectModel {

	
public static void main(String[] args) {
	
	//	To delete SM and MM files before start of Simulation
	
	File secdir=new File("/home/paras/Desktop/sec_mem");
	for(File file : secdir.listFiles())
		file.delete();
	File maindir=new File("/home/paras/Desktop/main_mem");
	for(File file : maindir.listFiles())
		file.delete();
	
	new StartPro();
	}
	
}
