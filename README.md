# Spinetti_Dominick_Capstone_CaseStudy

Repository for case study project

## Idea for project

golf course management app that breaks down each hole and provides different strategies for approaching the course. Each course will have photos of each hole and how to prepare.

## User Stories

### As a < type of user >, I want < some goal > so that < some reason >

- As a user, I want to create my own account so that I can access the application
    - As a user, I want my password to be unique so that nobody will have the same information as me
    - As a user, I want to be able to link my email to my account so that I can log in quickly

- As a user, I want my password to be secure so that my data stays safe
    - As a user, I want to use dual-factor authentication so that it is less likely for someone to have unauthorized access to my account

- As a developer, I want to use my own CSS style sheet so that my application is unique

- As a developer, I want store user log in history into my SQL database so that I can keep track of application usage

- As a user, I want to view which courses will be added to the application next so that I can know what to expect in the future
    - As a user, I want to be able to vote on the next course added so that I can play the courses I like

- As a user, I want to be able to make suggestions on the application's strategy so that I can help others improve
    - As a developer, I want someone with admin access to be able to approve user suggestions for a final post

## Potential logo

![Main logo](https://user-images.githubusercontent.com/99349506/157073478-f3134db6-360d-4b10-97a5-04be09bdad55.PNG)


## Development process

#### Update for 4/11/22
 - preparing profile page to autofill with user information
 - created userprofile model and its table creation in the database
 - overall percentage of completion estimate for overall project is about 70-80%
 - Unable to complete profile autofill until I can implement account creation and login. Unable to do so with base user login as of right now.
 - Changed all HTML files to snake case and created HTML files/GetMapping for Report a bug and Frequently asked questions. Also had to add new views to the navbar on each page that uses it.
 - Going to start with creating the database and tables for FAQ and Report a bug.

#### Update for 4/12/22
 - Overall percentage of completion is still around 70-80%
 - Creating the database and tables for Report a bug.
 - Running into issues with creating a second controller. I believe the main problem has to do with spring security causing issues.
 - going to try moving back to an older git version of the project and starting report a bug from scratch.

#### Update for 4/13/22 
 - Overall percentage of completion has grown to 75-80%
 - Successfully implemented CRUD operations for Report a bug
 - The change that fixed the issue was adding @Service to the ReportBugServiceImpl which resolved the IllegalStatement error as well as creating a new instance of reportbug in the controller and adding its attribute