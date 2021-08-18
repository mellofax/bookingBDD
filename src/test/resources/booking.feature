Feature: Booking Navigation
  Scenario: Navigate and verify that title is correct
    Given Navigate to online Booking page
    When Enter name of the Hotel "BonHotel"
    Then Press Search
    Then Check that the hotel with name "BonHotel" is displayed on the page
    Then Check that the hotel's rating corresponds to 9.0