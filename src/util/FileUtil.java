package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileUtil  {
	public static void copy(File srcFile,File destFile) throws Exception{
		FileInputStream fis= new FileInputStream(srcFile);
		FileOutputStream fos= new FileOutputStream(destFile);
		byte[] b=new byte[1024];
		int len=-1;
		while(-1!=(len=fis.read(b))){
			fos.write(b,0,len);
		}
		fos.flush();
		fis.close();
		fos.close();
		
	}
}
