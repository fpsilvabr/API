package br.com.inmetrics.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
   		 dryRun = false,
         monochrome = true,
		 features = { "./src/main/resources/features/" },
		 glue = {"br.com.inmetrics" }, 
		 tags = { "@backend" })
public class RunTest {

}