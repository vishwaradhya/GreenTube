@GreenTubeRest @rest
Feature: This feature is to verify HERE api
  

 
  @createAndupdate
  Scenario: Verify create and update map request should be successful
    Given user get the maps with pin for following places
    |Country	|longitude-latitude|
    |Germany	|52.5,13.4|
    |Italy		|41.9,12.5|
    |UK				|51.5,-0.1|
    And user verifies the status code 200
    When user updates maps by following values 
    |Country	|longitude-latitude|
    |France		|48.9,2.3 |
    |Spain		|40.4,-3.7|
    Then user verifies the status code 200
    
 
 @invalidAPIKEY
  Scenario: Verify the status code 401 for unauthorised user for invalid API KEY 
    Given user get the maps with invalid API KEY with following valid details
    |Country	|longitude-latitude|
    |Germany	|52.5,13.4|
    |Italy		|41.9,12.5|
    |UK				|51.5,-0.1|
    And user verifies the status code 401
    
    
 @invalidBaseUrl
  Scenario: Verify 404 not found when Base URL is wrong  
    Given user get the maps with invalid base url with following valid details
    |Country	|longitude-latitude|
    |Germany	|52.5,13.4|
    |Italy		|41.9,12.5|
    |UK				|51.5,-0.1|
    Then user verifies the status code 404