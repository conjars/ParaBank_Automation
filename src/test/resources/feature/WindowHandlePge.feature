Feature: verify functionality for Window Handle, Window Tabs, Multiple window handle


Scenario: Handle mutliple windows

Given user launches the browser and navigates to the "Window Handles Practice"
When user clicks on "Open New Window" button
Then user switches to the newly opened window and verify the title of the page
And user enter the basic details data by using JSON formart and click on  register button
