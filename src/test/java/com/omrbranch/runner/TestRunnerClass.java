package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, snippets = SnippetType.CAMELCASE, stepNotifications = true, publish = true, 
monochrome = true, plugin = {
    "pretty", "json:target\\output.json" }, name = {
        "Login into OmrBranch" }, glue = "com.omrbranch.stepdefinitio", features = "src\\test\\resources")
public class TestRunnerClass {

  @AfterClass
  public static void afterClass() {
    Reporting.generateJvmReport("D:\\Studies\\Framework\\Cucumber\\target\\output.json");

  }

}

