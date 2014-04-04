package util;

import java.util.UUID;

public final class VerifyUtil {
	public static String createVerifyCode(){
		UUID uuid=UUID.randomUUID();
		System.out.println(uuid);
		return uuid.toString();
	}
}
