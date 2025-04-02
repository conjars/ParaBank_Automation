Feature: Framehandling on the webPage
@topic
Scenario: verify user handle the iframe and nestedFrame

Given User open the "https://the-internet.herokuapp.com/" home page
When User click on "Frames" link
And user handle the iframe
And user handle  the nested frames
