Feature:  Navigating around the movie app

  Scenario:  Navigate to Index
    Given I have a browser open
    When I navigate to "http://localhost:8080"
    Then I am on the "Index" page

  Scenario:  Navigate to Movie
    Given I have a browser open
    When I navigate to "http://localhost:8080/movie"
    Then I am on the "Get All" page

  Scenario:  Navigate to Add Movie page
    Given I have a browser open
    When I navigate to "http://localhost:8080/movie/add"
    Then I am on the "Add Movie" page

