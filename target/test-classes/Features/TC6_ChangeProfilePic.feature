@ChangeProfilePic
Feature: Change Profile Pic Module API Automation

	Scenario Outline: Verify change profile pic to the application through API
		Given User add header and bearer authorization for accessing change profile pic endpoints
		When User add-formData and initialize the file location
    And User send "POST" request for change profile picture endpoint
    Then User should verify the status code is 200
    And User verify the Change Profile Picture response message matches with "Profile updated Successfully"