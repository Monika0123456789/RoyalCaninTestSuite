Feature: Add a review to a product

  Scenario: Login, navigate to PLP and PDP, and add a review to a product
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should be redirected to the homepage
    And the user navigates to the Product Listing Page (PLP)
    When the user selects a product from PLP
    Then the user should be on the Product Details Page (PDP)
    When the user clicks on Rating star
    #And the user fills in the review details
    #And the user submits the review
    #Then the review should be successfully submitted
