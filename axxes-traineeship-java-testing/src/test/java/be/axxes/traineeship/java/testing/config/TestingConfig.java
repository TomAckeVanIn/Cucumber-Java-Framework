package be.axxes.traineeship.java.testing.config;

import be.axxes.traineeship.java.testing.cucumber.CucumberContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestingConfig {

    @Bean
    public CucumberContext cucumberContext() {
        return new CucumberContext();
    }
}
