"# task-manager-case-study" 
Task Manager Case Study Build Notes:

task-manager-server - Maven Spring boot project for exposing rest endpoints + MySql project-manager-ui - Angular CLI for building UI and connects with rest endpoints exposed

Git Repository:https://github.com/srimeenakshigjgithub/task-manager-case-study.git

Maven Build Commands for the final artifacts:

clean install -e	[run the command for task-manager-server project which will build UI and service project and create the final jar with required resources] 

Commands for local development:

Make sure mysql is running in local machine Run maven command spring-boot:run for the project task-manager-server Check whether the endpoint is working fine in postman Endpoint : http://localhost:8181 Open the folder src/main/web of project task-manager-web in visual studio and then run below commands npm install npm start Hit the url http://loalhost:4200 and see whether the page is getting loaded

Jenkins command: Make sure Jenkins is installed and running Configure Maven and JDK in jenkins with name maven3 and jdk1.8 Create Jenkins project with Pipeline option and configure the below information i) Github repository with credentials ii) Branch to build: */master iii) Path to Jenkinsfile

Documents for Reference:

task-manager-server - service code
task-manager-web - Angular UI code
task-manager-scripts - table scripts to run in DB
Jenkins file - Jenkins details.
