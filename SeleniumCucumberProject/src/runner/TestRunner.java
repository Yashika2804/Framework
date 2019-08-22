package runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="features",
					glue="stepDefinition"
					//,plugin= {"html:target/cucumber-html-project"}
					)
public class TestRunner {

}
