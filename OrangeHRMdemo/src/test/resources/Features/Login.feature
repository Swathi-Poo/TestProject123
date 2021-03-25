@tags
Feature: To test Login Page of an orangeHRM application

Background: The purpose of this feature is to test the Background keyword
Given User is on login page

@login
Scenario Outline: To test login feature with invalid username and password
When user enter the "<username>" and "<password>"
Then user click on login button
And user should remain on login page with error message
Examples:
|username|password|
|Tom|tom123|
|Jerry|jerry123|
|Scobby|scobby123|
|Dolphin|dolphin123|
|Shark|shark123|
|dog|dog123|
|Elephant|elephant123|
|Lion|lion123|
|Fish|fish123|
|Apple|apple123|
|||

#@login
Scenario Outline: To test login feature with valid username and password
When user enter the "<username>" and "<password>"
Then user click on login button
And user should navigate to homepage
Examples:
|username|password|
|Admin|admin123|

@ForgetPassword
Scenario Outline: To test forgot Password feature
When user click on Forgot your password
Then user enter "<username>"
And user click on Reset password
And verify the username
Examples:
|username|
|Tom|
|Admin|