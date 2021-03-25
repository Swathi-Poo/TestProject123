Feature: To test home Page of an orangeHRM application

Background: The purpose of this feature is to test the Background keyword
Given User is on login screen
When user enter valid credentials
|username|Admin|
|password|admin123|
And user click on login


Scenario: To test leave menu
When user click on leave menu 
Then user click on reports submenu
Then user select generate for

@link
Scenario: To test all the links in the home page
When user gets all the links
#Then user click on the links in new tab


