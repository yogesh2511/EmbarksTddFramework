# Embark Portal Automation

This repository contains the automation framework for testing the Embark Portal. The framework is implemented using Selenium, TestNG, and Java.

## Test Case Steps

1. **Navigate to Embark Portal**
   - Go to `https://www.embark.org/?ref=madewithvuejs.com`.

2. **User Registration**
   - Register a new user with randomly auto-generated data.

3. **User Login**
   - Login with the newly registered user credentials.
   - Click on "Host an Adventure" link at the top right corner.

4. **Adventure Details Entry**
   - Enter Category, Difficulty level, City and save it using data from an Excel file.
   - Verify validation message for Group Size.
   - Enter Group Size and save it.

5. **Complete Adventure Details**
   - Fill in the sections: Overview, Location, Photos, Details, and Itinerary with data from Excel.
   - Save the entered details.
   - Verify the success message "Tour updated successfully".

6. **Tour Verification**
   - Click on "View Tour" link at the bottom left and open it in a new tab.
   - Verify the tour details.
   - Click on "Save to Wishlist" button and verify it is saved.

7. **Logout**
   - Close the current tab, switch back to the main tab, and logout from the website.
   - Verify the user is successfully logged out.

## Implementation Details

The automation framework is implemented with the following components:

1. **Maven Project**:
   - The project is structured as a Maven project and includes a `pom.xml` file for managing dependencies.

2. **TestNG Framework**:
   - TestNG is used for test execution.

3. **Page Object Model (POM)**:
   - The Page Object Model is used to organize code and improve maintainability.

4. **Object Repository**:
   - Locators are maintained in an Object Repository.

5. **Usage of OOPS Concepts**:
   - Object-Oriented Programming concepts are applied throughout the code.

6. **Extent Report**:
   - Extent Reports are generated for test execution results.
   - Screenshots of each page are attached to the report.

7. **Test Status in Excel**:
   - Test statuses (pass/fail/skip) are recorded in an Excel file.

8. **Screenshot Capture**:
   - Screenshots are captured and attached to the Extent Report for each page.

9. **Logger Implementation**:
   - Logging is implemented to capture detailed test execution information.

10. **Apache POI**:
    - Apache POI is used to read data from Excel files for test input.

## Repository Information

- **Repository**: [EmbarkPortalAutomation](https://github.com/yogesh2511/EmbarksTddFramework )
- **Owner**: yogesh2511
- **Repository ID**: 960497357
- **Description**: EmbarkPortalAutomation

## Current Date and Time

- **UTC Date and Time**: 2025-04-05 14:37:29
- **User**: yogesh2511
