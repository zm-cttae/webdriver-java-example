#Author: Zakaria.Jebril@fdmgroup.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Universities Page
  
  @RegisterSmokeTest
  Scenario: Test that the university details are correct
    Given that the browser is open
    And the user is on the FDM webpage
    When I hover over the OUR WORK link
    Then The UNIVERSITIES button is displayed
    When I click the UNIVERSITIES button
    Then The universities page is displayed
    And A slide shows that there are ninety+ uni partnerships
    And A slide mentions four-hundred-and-eighty+ universities
    When I click the left arrow under Global Recruitment'
    Then A slide mentions two-hundred+ high-profile clients
    When I click View brochure button
    Then The FDM brochure is displayed
    When I click the browser back button
    Then The universities page is displayed
    When I click the GBR button
    Then A dropdown list is displayed
    And The list contains an option to switch to "<language>"
    When I click the "<language>" button
    Then The "<language>" universities page is displayed
    And The universities page heading is now known as "<heading>"
    When I click the browser back button
    Then The universities page is displayed
  
  Examples:
		| language      | heading      |
		| Deutsch       | Hochschulen  |
		| English - USA | Universities |
