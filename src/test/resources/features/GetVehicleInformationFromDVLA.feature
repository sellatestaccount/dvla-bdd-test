Feature: Get vehicle Information from DVLA

  Scenario: Get vehicle information successfully using vehicle registration number
    Given I am on vehicle information from DVLA page
    And I click Startnow
    When I enter the vehicle registration number "LV10FZD" on vehicle enquiry service
    And I click Continue
    And I select "yes" to confirm vehicle
    And I click Continue to confirm vehicle
    Then the vehicle details page should contain the following information
    | vehicleRegistrationNumber | vehicleMake  | vehicleColour  |
    | LV10 FZD                   | NISSAN       | RED    |
