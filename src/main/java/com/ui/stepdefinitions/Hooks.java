package com.ui.stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.framework.actions.BaseAbstract;
import com.framework.actions.ScreenShotMethods;
import com.framework.commonutils.PropertiesFile;
import com.framework.initialization.ConfigurationPath;
import com.framework.initialization.DriverInitalization;
//import com.rest.utils.MakePostsUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseAbstract {

	private static Logger logger = LogManager.getLogger(Hooks.class);

	DriverInitalization driverInitialize = new DriverInitalization();
	protected static final Map<String, String> CONFIG_DETAILS = new HashMap<>();
	ScreenShotMethods takeScreenShotObj = new ScreenShotMethods();

	static {

		CONFIG_DETAILS.put("Browser", PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "Browser"));

	}

	@Before
	public void beforeScenario(Scenario scenario) {

		if (!scenario.getSourceTagNames().contains("@rest")) {
			driver = driverInitialize.getDriver(CONFIG_DETAILS);
		} else {
			logger.info("Ignore browser launch for api/rest tests");
		}
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {

			takeScreenShotObj.takeScreenShot();
		}
		//closeDriver();

	}
}
