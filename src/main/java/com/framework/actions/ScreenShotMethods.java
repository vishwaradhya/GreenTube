package com.framework.actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.initialization.DriverInitalization;

public class ScreenShotMethods extends DriverInitalization {
	
	
	/** Method to take screen shot and save in ./Screenshots folder*/
	public void takeScreenShot() throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		
		
		File currentDirFile = new File("Screenshots");
		String path = currentDirFile.getAbsolutePath();
		
		
		FileUtils.copyFile(scrFile, new File(path+"\\screenshot"+dateFormat.format(cal.getTime())+".png"));
		
	}
	 
}
