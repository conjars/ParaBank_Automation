Feature: Hover and scroll Functionality and Heroupp
@smokeTest
Scenario: Scroll down an element and hover over the image

Given user launches the heroApp HomePage
When  user scrolls down to the Hvers section
And user hovers over the first image 
Then  user should see the user profile name
