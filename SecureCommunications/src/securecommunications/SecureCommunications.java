package securecommunications;

import java.applet.Applet;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import com.sun.crypto.provider.*;

public class SecureCommunications extends Applet {
	private static final Boolean debugMode = false;

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome to SecureCommunications\r\n");
		System.out.print("Enter your message then press ENTER\r\n");

		String message = System.console().readLine();
		Message m = new Message(message);
		
		String enc = new String();
		enc = Encryption.encrypt(m.content);
		//System.out.print("Encrypted message: " + enc + "\r\n");
		
		String dec = new String();
		dec	 = Encryption.decrypt(enc);
		if (debugMode)
		{
			System.out.print("Cleartext message: " + dec + "\r\n");
		}
		
		HttpRequest http = new HttpRequest(); 
		Integer code = http.sendGet(enc);
		if (code.equals(200)) {
			System.out.print("Message sent.\r\n");
		}
		else {
			System.out.print("Error while sending the following message: " + m + "\r\n");
		}
	  
	}
	
}
