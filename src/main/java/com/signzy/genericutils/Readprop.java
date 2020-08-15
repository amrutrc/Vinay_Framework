package com.signzy.genericutils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Readprop {

	Properties property;
	FileInputStream fis;

		public String fetchproperty(String propToFetch) throws IOException{				
		property=new Properties(); 
		fis = new FileInputStream (System.getProperty("user.dir")+"\\testdata\\properties\\testProp.property");
		property.load(fis);
		return property.getProperty(propToFetch);
	}
}