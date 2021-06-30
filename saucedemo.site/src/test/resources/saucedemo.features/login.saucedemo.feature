#Scenario is executed only once, whereas Scenario outline (For similar data trace) can be executed multiple times depending upon the data provided as Example
#Background in Cucumber is used to define a step or series of steps that are common to all the tests in the feature file.
#In Cucumber, tags are used to associate a test like smoke, regression etc. with a particular scenario.
#By default, Cucumber executes all the scenarios inside the feature file, but if we need to execute or skip any specific scenario under a specific test, so we can declare scenarios within a tag.
@WholeLogin
Feature: Login to saucedemo sitee

  Background: 
    Given user launches saucedemo site in chrome bowser

  @SmokeTest
  Scenario Outline: 
    And Enters the <Username> and <Password>
    Then clicks on Login button
    And user clicks on logout and closes the browser

    Examples: 
      | Username      | Password     |
      | standard_user | secret_sauce |

  @Regression @Test
  Scenario Outline: 
    And Enters the <Username> and <Password>
    Then clicks on Login button
    And user clicks on Add to cart button
    Then user navigates to Add to cart
    And Checks if the item is added to the cart
    And user clicks on logout and closes the browser

    Examples: 
      | Username      | Password     |
      | standard_user | secret_sauce |
