package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Duplication of Class. 1,Create ObjectOutputStream to operate
 * Object-----serialization---->ByteArrayOutputStream 2,Create ObjectInputStream
 * to operate ByteArrayInputStream---re-serialization-->Object.
 * 
 * p1 p2 has different address .but the same content.
 * @author Cxx
 * 
 */
public class Serialization{

	public static Object copy(Object obj) throws IOException, Exception {
		ByteArrayOutputStream buff= new ByteArrayOutputStream();
		ObjectOutputStream oos= new ObjectOutputStream(buff);
		oos.writeObject(obj);
		
		byte[] objBuff = buff.toByteArray();
		ByteArrayInputStream input= new ByteArrayInputStream(objBuff);
		ObjectInputStream bis= new ObjectInputStream(input);
		
		return bis.readObject();
	}

}
