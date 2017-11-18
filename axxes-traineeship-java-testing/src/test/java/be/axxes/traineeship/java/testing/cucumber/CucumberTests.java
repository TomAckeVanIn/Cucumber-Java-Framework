package be.axxes.traineeship.java.testing.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"classpath:features"},
        tags = {"~@ignore"},
        glue = {"be.axxes.traineeship.java.testing.cucumber", "cucumber.api.spring"},
        plugin = {"pretty", "json:target/cucumber-json/axxes-traineeship-tests.json"},
        monochrome = true
)
public class CucumberTests {}
