package com.SeleniumEasy.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AccessPropertyFileUtility {

	public static Properties getPropertyObject() throws IOException {

		Properties prop = new Properties();

		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "/SeleniumEasy.properties");

		prop.load(fileInput);

		return prop;
	}

}
