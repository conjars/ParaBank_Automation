Feature: Google Doodle Library Multi-Color Selection
	@color
  Scenario: Select multiple colors in the Google Doodle Library
    Given I navigate to Doodle "https://www.google.com/doodles"
    When I click on the "Library" link
    And I click on the "Color" filter
    And I select "colors" "Multicolor" and "Black"
    Then I verify that doodles are filtered based on the selected colors
 @topic
 Scenario: Select multiple colors in the Google Doodle Library
    Given I navigate to Doodle "https://www.google.com/doodles"
    When I click on the "Library" link
    And I click on the "Topic" filter
    And I select "topics" "Animation" and "Architecture"
    Then I verify that doodles are filtered based on the selected colors
 
