@regression
Feature: Validating select and edit add row timesheet functionalities
  @MB4-141
  Scenario: Validating select timesheet for week dropdown
    Given user send username "Admin" and password "admin123"
    When user navigates to "My Timesheets" page
    And user chooses and clicks one of the "weeks" weeks from dropdown
    Then user validates the desired "week" week is selected

  @MB4-145
  Scenario:  Validating edit add row timesheet functionality
    Given user send username "Admin" and password "admin123"
    When user navigates to "My Timesheets" page
    And user adds a row to the "week" week
    Then user validates the row is added