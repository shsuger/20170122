package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws 
	UnsupportedEncodingException {
		String str = "¥Û ¶–÷";
		String str2 = URLEncoder.encode(str,"utf-8");
		System.out.println(str2);
		String str3 = URLDecoder.decode(str2,"utf-8");
		System.out.println(str3);
	}

}
