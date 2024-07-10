@City
Feature: City Module API Automation

  Scenario: Verify User Get CityList through API
    Given User add headers for to get CityList
    When User add request body state id for get city list
    When User send "POST" request for CityList endpoint
    Then User should verify the status code is 200
    And User should verify the cityList response message matches "Salem" and saved city id
