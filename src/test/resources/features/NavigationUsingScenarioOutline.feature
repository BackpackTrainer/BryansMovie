@Navigate
Feature:  Using a scenario outline

  Scenario Outline:  Navigate to Index
    Given I have a browser open
    When I navigate to <web url>
    Then I am on the <page title> page

    Examples:
      | web url                           | page title  |
      | "http://localhost:8080"           | "Index"     |
      | "http://localhost:8080/movie"     | "Get All"   |
      | "http://localhost:8080/movie/add" | "Add Movie" |
