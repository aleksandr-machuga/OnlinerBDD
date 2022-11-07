Feature: As a user
  I want to get ability to see menu subcategories

  Scenario: Menu category Автобарахолка should contain appropriate subcategories
    Given the user opens Onliner website
    When the user hovers menu category "Автобарахолка"
    Then the user sees submenu
    And submenu has price group
    And submenu has city group
    And submenu has brand group

  Scenario:  Menu category Дома и квартиры should contain appropriate subcategories
    Given the user opens Onliner website
    When the user hovers menu category "Дома и квартиры"
    Then the user sees submenu
    And submenu has price group
    And submenu has city group
    And submenu has rooms group


