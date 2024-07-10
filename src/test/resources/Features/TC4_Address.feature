@Address
Feature: Address Module API Automation

  @AddAddress
  Scenario Outline: Verify add user address to the application through API
    Given User add header and bearer authorization for accessing Addaddress endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>",and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment       | state | city | country | zipcode | address       | address_type |
      | Praveen    | KG        | 7667588599 | Krishna Nivasam |   123 |   11 |     101 |  636007 | Shankar Nagar | Home         |

  @UpdateAddress
  Scenario Outline: Verify update user address to the application through API
    Given User add header and bearer authorization for accessing Updateaddress endpoints
    When User add request body to Update address "addressId","<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>",and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment       | state | city | country | zipcode | address       | address_type |
      | Praveen    | KG        | 7667588599 | Krishna Nivasam |   126 |   14 |     101 |  636007 | Shankar Nagar | Home         |

  @GetAddress
  Scenario: Verify GetUserAddress to the application through API
    Given User add header and bearer authorization for accessing Getaddress endpoints
    When User send "GET" request for getUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the getUserAddress response message matches "OK"

  @DeleteAddress
  Scenario: Verify address is deleted or not in the application through API
    Given User add header and bearer authorization for accessing Deleteaddress endpoints
    When User add request body to delete address "addressId"
    And User send "DELETE" request for deleteAddress endpoint
    Then User should verify the status code is 200
    And User should verify the deleteAddress response message matches "Address deleted successfully"
