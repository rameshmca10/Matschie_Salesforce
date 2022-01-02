Feature: Create New Lead

  Scenario: Create a new Lead with details
    Given enable logs
    And Lead details are added in body './data/Lead.json'
    Then the status code is 201
    And response includes the id

  Scenario: Update an existing Lead with details
    Given get lead id to 'update'
    When Lead details are updated in body './data/Lead.json'
    Then the status code is 204

  Scenario: Delete an existing Lead with details
    Given get lead id to 'delete'
    When Lead details are deleted
    Then the status code is 204

    
  Scenario: Verify Lead deleted
    Given get lead id to 'deleted'
    When Lead details are not loaded
    Then the status code is 404