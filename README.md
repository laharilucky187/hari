# bank-application

This application has a back-end REST APIs implemented in Spring-Boot 2.1.6 and a frond-end UI implemented in Angular 8. It also uses BootStrap CSS library.

Prerequisit to run the project:
1. Node.js and npm
2. Java 11
3. Maven

Build the project using: mvn clean install

Run project using: mvn spring-boot:run

Application available at: http://localhost:8083/bank-application/
Swagger API documentation at: http://localhost:8083/bank-application/swagger-ui.html

To run UI application & Back-end application separately:
1. Run spring-boot application by running main class.
2. Run command prompt and go to folder /client.
3. Run command "npm start" to start Angular UI application.
4. Go to URL http://localhost:4200/
