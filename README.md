How do I run Cucumber scenario's?

####Browser Drivers

The framework uses the following library to automatically download the latest version of ChromeDriver and GeckoDriver (FireFox): https://github.com/bonigarcia/webdrivermanager

####JUnit

-Dspring.profiles.active={browser}
=> where browser is chrome, firefox or sauceLabs

####Maven

mvn clean install -Dspring.profiles.active={browser}
=> where {browser} is |chrome|ie| for local execution or |sauceLabs| when triggering from Jenkins

-Dcucumber.options="--tags @TAG1,@TAG2"
=> where TAG1 and TAG2 are the linked scenario's you want to run