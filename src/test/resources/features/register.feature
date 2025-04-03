Feature: register
    As a user
    I want to register an account with already registered user

    Scenario: register with valid credentials
        Given I am on register page
        When I enter a already registered email address "testtest@gmail.com"
        And I click register button
        Then The error message should be displayed "Lỗi: An account is already registered with your email address. Please log in."
