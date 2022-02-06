
  Feature: Statefarm get a quote 
  I open statefarm website, click on the dropdown and assert the options,
  click on the second option, type in the zipcode and click on the get a 
  quote button
  
  Scenario: Click on dropdown, select the second option and enter zipcode
    Given I am on state farm main page
    When I click on the dropdown menu
    And Assert the dropdown values
    And choose the second option in dropdown
    And Enters the zipcode
    
   
