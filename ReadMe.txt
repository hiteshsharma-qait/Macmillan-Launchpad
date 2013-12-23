
	
	 For execution of 'Macmillan Launchpad Automation' using 'Selenium-TestNg'
	**************************************************************************

###############################################################################################

1) To execute the smoke test for questions
	
	 open the root folder in command line and execute the below given command

	==>> mvn clean verify -Dtest=SmokeTestForQuestions.xml

################################################################################################

2) To execute the complete suite

	 open the root folder in command line and execute the below given command

	==>> mvn clean verify -Dtest=TestNG.xml

################################################################################################

	--Results would be stored in root folder ".target\surefire-reports\emailable-report.html"


	==========================================================================