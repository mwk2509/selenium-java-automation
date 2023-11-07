package com.automation.utilities;

import java.io.FileReader;
import java.util.Properties;

public class LoadProperties {

	public static String getData(String key) {
		String value = "";
		try {
			FileReader fr = new FileReader("user.properties");
			Properties props = new Properties();
			props.load(fr);
			
			value = props.getProperty(key);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return value;

		//System.out.println(fr.grtproperty( "password"));
		//System.out.println(fr.grtproperty( "url"));
		
	}

}
