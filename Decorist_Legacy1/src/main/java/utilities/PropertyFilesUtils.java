package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import BusinessRules.Constants;
import BusinessRules.Log;

public class PropertyFilesUtils {

	public static FileInputStream file;
	public static Properties prop;
	
	public static String getPropertyFromUrlFile(String propertyName) {
		String propValue="";
		try {
			file=new FileInputStream(Constants.urlFile);
			prop=new Properties();
			prop.load(file);
			propValue=prop.getProperty(propertyName);
			Log.info("Pass: "+Constants.urlFile+" is loaded successfully.Property name: "+propertyName+" namd value: "+propValue);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.info("Fail: "+Constants.urlFile+" Could not be loaded");
			Assert.fail();
		} catch (IOException e) {
			Log.info("Fail: "+Constants.urlFile+" Could not be loaded");
			e.printStackTrace();
			Assert.fail();
		}
		
		return propValue;
	}
}
