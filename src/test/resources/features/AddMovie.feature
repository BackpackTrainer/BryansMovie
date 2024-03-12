@AddMovie
Feature:  Add a movie
  User Story:  As a collector, I want to be able to add a movie to my collection.
  
  Acceptance Criteria:
  Adding a movie requires a movie name and ISBN.  We can add a movie without knowing the genre
  Demonstrate that we can add each type of movie (4 tests total)

  Descriptive error message displayed if no ISBN (Must take a screenshot)
  Descriptive error message displayed if no Movie title (Must take a screenshot)

  Get both error messages if both ISBN and Title are missing (Must take a screenshot)


  Scenario:  Add a comedy Movie, everything works
    Given I have a browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "123-56" in the ISBN Box
    And I enter "Random" in the title box
    And I select "Comedy" from the dropdown
    And I click submit
    Then I see that "Random" was successfully added


  Scenario:  Add a comedy Movie with no title
    Given I have a browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "123-56" in the ISBN Box
    And I enter "" in the title box
    And I select "Comedy" from the dropdown
    And I click submit
    Then I see that an error message containing "titles"


  Scenario:  Add a comedy Movie with no ISBN
    Given I have a browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "" in the ISBN Box
    And I enter "Random" in the title box
    And I select "Comedy" from the dropdown
    And I click submit
    Then I see that an error message containing "ISBN"


  Scenario:  Add a comedy Movie with no ISBN or Movie Title
    Given I have a browser open
    When I navigate to "http://localhost:8080/movie/add"
    And I enter "" in the ISBN Box
    And I enter "" in the title box
    And I select "Comedy" from the dropdown
    And I click submit
    Then I see that an error message containing "titles"
    Then I see that an error message containing "ISBN"