@homework
Feature: Validating Porsche Price
  Background: Repeated first steps i each scenario.
    Given user navigates to Porsche Application
    When user stores the price and selects the model 718 Cayman
  Scenario:Validating Porsche Price

    Then user validates Base price is matched with listed price

    Scenario: Validating Porsche Price For Equipment

      And user adds Power Sport Seats (14-way) with Memory Package
      Then user validates that Price For Equipment is added and price matches

