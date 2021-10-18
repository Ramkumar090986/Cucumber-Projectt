$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/login.feature");
formatter.feature({
  "name": "Verify the login functionality of the facebook",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Varify the login by giving invalid user name and valid password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user have to launch the browser and enter the url",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_have_to_launch_the_browser_and_enter_the_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters the invalid username and valid password",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.user_enters_the_invalid_username_and_valid_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on the login button",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user not display the homepage of the application",
  "keyword": "But "
});
formatter.match({
  "location": "StepDefinition.user_not_display_the_homepage_of_the_application()"
});
formatter.result({
  "status": "passed"
});
});