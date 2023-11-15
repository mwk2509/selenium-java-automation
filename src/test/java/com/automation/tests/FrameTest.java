package com.automation.tests;
import org.testng.annotations.Test;

import com.automation.actions.ActionEngine;
import com.automation.pages.FramePage;


	public class FrameTest extends ActionEngine {
		FramePage FramePage = new FramePage();
		
		@Test
		public void switchToFrame() throws Exception{
			extentTest = extentReports.startTest("FrameTest", "Frame Test desc");
			FramePage.switchFrame();
		}

	}


