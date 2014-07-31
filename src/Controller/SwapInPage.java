package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SwapInPage {

	
	public static void copy(String files,String file) throws Exception
	{
		
		File srce = new File(files);
		File desc = new File(file);
		desc.createNewFile();
		InputStream in = new FileInputStream(srce);
	    OutputStream out = new FileOutputStream(desc);

	    // Copy the bits from input stream to output stream
	    byte[] buf = new byte[1024];
	    int len;
	    while ((len = in.read(buf)) > 0) {
	        out.write(buf, 0, len);
	    }
	    
	    in.close();
	    out.close();
	    
		 /* File f=new File(files);
		  if(f.exists())
			  f.delete();*/
	}
}
