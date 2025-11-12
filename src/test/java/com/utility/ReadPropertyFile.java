package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class ReadPropertyFile {

	public static String readProperty(Env env, String propertyName)
	{
		System.out.println(System.getProperty("user.dir")+"//Config//"+env+".properties");
		File file = new File(System.getProperty("user.dir")+"\\Config\\"+env+".properties");
		FileReader fileReader;
		Properties prop = new Properties();
		try {
			fileReader = new FileReader(file);
			prop.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String value = prop.getProperty(propertyName);
		return value;
	}
}
