Feature: Validating etsy titles

  Scenario Outline: Validating etsy separate page titles
    Given user navigates to Etsy application
    When user clicks on "<Section>" section
    Then user validates title is "<Title>"

    Examples:
      | Title                                         | Section                  |
      | The Best Mother's Day 2022 Gift Ideas \| Etsy | Mother's Day Gifts       |
      | Jewelry & Accessories \| Etsy                 | Jewelery and Accessories |
      | Clothing & Shoes \| Etsy                      | Clothing & Shoes         |
      | Home & Living \| Etsy                         | Home & Living            |
      | Wedding & Party \| Etsy                       | Wedding & Party          |
      | Toys & Entertainment \| Etsy                  | Toys & Entertainment     |
      | Art & Collectibles \| Etsy                    | Art & Collectibles       |
      | Craft Supplies & Tools \| Etsy                | Craft Supplies           |
      | The Etsy Gift Guide for 2022 \| Etsy          | Gifts & Gift Cards       |