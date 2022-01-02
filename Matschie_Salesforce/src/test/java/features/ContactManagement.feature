Feature: Create New Contact

  Scenario: Create a new contact with details
    Given enable logs
    And contact details are added in body './data/Contact.json'
    Then the status code is 201
    And response includes the id

  Scenario: Update an existing contact with details
    Given get id
    When contact details are updated in body './data/Contact.json'
    Then the status code is 204

  Scenario: Delete an existing contact with details
    Given get id
    When contact details are deleted
    Then the status code is 204

    
  Scenario: Verify contact deleted
    Given get id
    When contact details are not loaded
    Then the status code is 404
    