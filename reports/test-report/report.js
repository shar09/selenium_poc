$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Test the login functionality on TestProject Demo webpage",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The user should be able to login with correct username and correct password",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.discover.cucumber.stepDefinitions.BDDLoginTest.user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters correct username and correct password",
  "keyword": "When "
});
formatter.match({
  "location": "com.discover.cucumber.stepDefinitions.BDDLoginTest.user_enters_correct_username_and_correct_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be redirected to welcome page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.discover.cucumber.stepDefinitions.BDDLoginTest.user_should_be_redirected_to_welcome_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});