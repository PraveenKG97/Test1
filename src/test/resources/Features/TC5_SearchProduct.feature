@Search
Feature: Search Product Module API Automation

  Scenario Outline: Verify search product to the application through API
    Given User add header for accessing search product endpoints
    When User add request body for search product "nuts"
    And User send "POST" request for SearchProduct endpoint
    Then User should verify the status code is 200
    And User should verify the SearchProduct response message matches product type is "product"
      