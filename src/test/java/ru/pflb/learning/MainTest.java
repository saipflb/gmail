package ru.pflb.learning;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"ru.pflb.learning.stepdefinitions"}
)

public class MainTest extends AbstractTestNGCucumberTests{
}
