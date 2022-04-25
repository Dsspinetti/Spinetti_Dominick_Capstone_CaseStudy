# Spinetti_Dominick_Capstone_CaseStudy

Repository for case study project

link to GitHub repository: https://github.com/Dsspinetti/Spinetti_Dominick_Capstone_CaseStudy

link to rubric completion checklist (Contact Sang Shin to access this document) : https://docs.google.com/document/d/179mEQMDMxmNYVaAxFVI0MCFZZD5136gTeXxZk4KPjJs/edit

## Idea for project

Golf course management app that breaks down each hole and provides different strategies for approaching the course. Each course will have photos of each hole and how to prepare.
While this has not been implemented yet, the end goal is to allow each user to add comments to each hole or course to provide their own input similar to a social media app.

 - [User Stories](#user-stories)
 - [Potential Logo](#potential-logo)
 - [Technical Architecture](#technical-architecture)
 - [Development Process](#development-process)
 - [Technical Challenges](#technical-challenges)
 - [Future Implementations](#future-implementations)
 
 

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



![Link to wireframe](https://github.com/Dsspinetti/Spinetti_Dominick_Capstone_CaseStudy/blob/master/Spinetti_Dominick_Wireframe.pdf)

## Technical Architecture

 - Technologies used
   - Java
   - bootstrap
   - HTML 5
   - CSS 
   - JavaScript
   - Spring-boot
   - MySQL
   - Git
   - Planning to implement mockito testing
  
  ![Technical Architecture](https://github.com/Dsspinetti/Spinetti_Dominick_Capstone_CaseStudy/blob/master/Technical%20Architecture.pdf)
  
  ![Table Schema](https://github.com/Dsspinetti/Spinetti_Dominick_Capstone_CaseStudy/blob/master/Table_Schema.png)
  



## Development process

admin login is
username: dspinetti@company.com
password: password

#### Update for 4/11/22 (70-80%)
 - preparing profile page to autofill with user information
 - created userprofile model and its table creation in the database
 - overall percentage of completion estimate for overall project is about 70-80%
 - Unable to complete profile autofill until I can implement account creation and login. Unable to do so with base user login as of right now.
 - Changed all HTML files to snake case and created HTML files/GetMapping for Report a bug and Frequently asked questions. Also had to add new views to the navbar on each page that uses it.
 - Going to start with creating the database and tables for FAQ and Report a bug.

#### Update for 4/12/22 (70-80%)
 - Overall percentage of completion is still around 70-80%
 - Creating the database and tables for Report a bug.
 - Running into issues with creating a second controller. I believe the main problem has to do with spring security causing issues.
 - going to try moving back to an older git version of the project and starting report a bug from scratch.

#### Update for 4/13/22 (75-80%)
 - Overall percentage of completion has grown to 75-80%
 - Successfully implemented CRUD operations for Report a bug
 - The change that fixed the issue was adding @Service to the ReportBugServiceImpl which resolved the IllegalStatement error as well as creating a new instance of reportbug in the controller and adding its attribute

#### Update for 4/14/22 (80%)
 - Overall percentage of completion is now around 80%
 - Successfully implemented user registration and login. A new user is now able to create their own account from the create account page and log in with their new credentials as well.
 - Added feature to profile page where users information automatically populates on entry
 - No major impediments came with this implementation.

#### Update for 4/15/22 (80%)
 - Overall percentage of completion is still hovering around 80%
 - I would like to start working towards displaying a page for the courses after a user selects one on the home page as well as implementing crud operation for the FAQ page
 - Created table and Crud operations for FAQ page. Working on implementing a method for creating a new question and having it display on the FAQ page.

#### Update for 4/18/22 (85%)
 - I was able to successfully implement the add Question feature for the FAQ page so that an admin can add a new question, and it will display on the main page.
 - With this information, I can now implement the same functionality into the course page

#### Update for 4/19/22 (80%)
 - Planning on spending most of the day creating the course model and a few functionalities that come with it.
 - had a lot of discussion with a few classmates about the best approach to creating a course model and its relationship with the course strategy table. There is definitely a lot of work to be done and a technical challenge of allowing user to upload an image will be difficult.
 - So far, I have successfully implemented new course creation on the home page. Still working on image upload.
 - Going to start implementing course strategy page/table and its relationship with the course table now. 
 - Thinking of shifting this card-to-course page relationship to utilize a different method similar to how the update customer works on our my-first-fullstack app. 

#### Update for 4/20/22 (85%)
 - Added mapping for the course page so that when a new course is added on the home screen the course is now a clickable link that will take them to the strategy page.
 - Added wireframe PDF and table schema photo to root directory. 
 - Going to start working on testing as most requirements are already fulfilled for app layout I would like to start preparing the project for submission before polishing up other operations. 
 - Successfully implemented tests for CourseRepository, FAQRepository, and ReportBugRepository.
 - Added more test classes for repositories and added delete mapping for course and faq pages.
 - Created the rest of the testing classes for Impl classes.

#### Update for 4/21/22 (85%)
 - Going to start working on image upload for creation of a new course. 
 - Have a very rudimentary system for uploading files, but it needs a lot of work. In its current state, the user has to specify the file path when creating a new course for it to display the image. 
 - Been looking into other methods to likely replace my current photo storage method.

#### Update for 4/22/22 (90-95%)
 - I have abandoned the file upload strategy and am just having the user submit a link to the photo of the course from the golf pass website. This method is working fine.
 - As turn in date is approaching, I am going to start working on polishing for the final project submission.

#### Update for 4/23/22 (90-95%)
 - Implemented search bar functionality for the home page.
 -  Still need to implement testing class for this custom query



## Technical Challenges

 - The first challenge that arose successfully implementing CRUD operations for the USER, FAQ, and REPORT A BUG tables. After talking with fellow learners and reviewing my code these challenges were resolved.
 - The second challenge that arose was the issue with the spring security. The original page with default user, admin, and super-admin gave no difficulty but implementing user registration added a few difficult hurdles to overcome due to changes needing to be made to the UserService and UserServiceImpl.
 - Had a lot of trouble adding functionality for adding a new question to the FAQ database and having it display on the FAQ page. (The solution was very simple...I had the model.addAttribute in the wrong mapping)
 - Not sure which method of taking an uploaded photo from a user and storing it into the database will work best.


## Future Implementations

 - Add more user interaction with the course strategy page, so they can suggest changes
 - Make the hole image on the course page so that the user can test different yardages. 
