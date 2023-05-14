package runners;

//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions (
		features={"src/test/resources/Appfeatures"},
		glue= {"com.qa.stepdefinition","com.qa.hooks"},
		monochrome = true,
		plugin= {"pretty","html:target/cucumber-reports","json:target/cucumber.json"}
		//tags = {"@negative"}
		)
public class MyTestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][]scenarios(){
		return super.scenarios();
	}

}


