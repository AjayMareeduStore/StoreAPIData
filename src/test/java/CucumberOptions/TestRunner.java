package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/FeatureFiles/SkuPreviewRetrieve.feature",
plugin="json:target/jsonReports/cucumber-reports.json",glue={"StepDescription"},tags="@verifytestGetPayLoad")
public class TestRunner {
	//tags="@DeletePlace"
	//tags="@VerifySkupreviewNotAvailable"
	//tags="@VerifySkupreviewAvailable"
	
   
}
