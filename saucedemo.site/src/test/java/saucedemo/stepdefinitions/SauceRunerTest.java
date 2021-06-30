package saucedemo.stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/saucedemo.features/login.saucedemo.feature",glue={"saucedemo.stepdefinitions"},monochrome = true,

plugin ={"pretty","html:target/reports.html","json:target/cucumber.json"},tags="@SmokeTest or @Test")

public class SauceRunerTest{


}

//NOte: Tags can only be placed for Feature,Scenario,ScenarioOutline,Examples its not possible to use for Given,When and And
//All the feature files can be executed at a go by just giving the path of the feature file folder, if you want any specific feature file give the exact specific path
//    Uses of test runner:
//	We can run multiple feature files at a time
//	We can execute the scenarios depending up on the specific tags declared in the feature file
//	To generate Reports
//@CucumberOptions can be used to provide additional configuration to the runner like tags,plugin,monochrom
//@RunWith() is Junit annotation, which tells Junit which is test runner class

//To run the project direct through rightclick>>MavenTest make sure the test runner class ends with "Test.java"
//By Downloading and installing apachemaven in the system and setting it as environmental variable , user can run the maven project through cmd.

//Steps to generate the HTML reports
//1)Add Mavem cucumber reporting dependencies <build> </build> pulgin in pom.xml 
//2)First run the project rightclick>>MavenTest (make sure Json is added in the testrunner plugin)
//3)opem cmd prompt get in to c:"path of the project"
//4)type mvn verify -DskipTests and wait for the html reports to generate in the project