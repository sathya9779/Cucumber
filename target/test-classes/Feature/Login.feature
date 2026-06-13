Feature: Verifying OmrBranch Login Module
	Scenario Outline: Login into OmrBranch
		Given User is on the OmrBranch Login Page
		When User enters "<username>" and "<password>"
		And User click the login button
		Then User should verify successful login message after login
		Examples:
				|username|password|
				|sat19941219@gmail.com|Sathya@1234|