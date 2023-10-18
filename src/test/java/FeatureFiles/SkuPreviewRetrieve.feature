Feature: validate the able to see the skupreview URL is mapping for the requsted Design

@verifyBspGetPayLoad
Scenario: Verify that skupreviewurl was not available of requestedc commerceID in PDP Pages

Given User should be able to navigate to home page with logged in state
When User should be able to navigate to the books page as expected
#Then Split the url and store it in the payload to run API Test

#@VerifySkupreviewAvailable
#Scenario: Verify User should be able to see the skupreviewURL in the response Data for requested CommerceID

#Given Arrange the BASEURI and Required parameter
#When Able to the hit the Post call with the arrange data
#Then verify the data received for the statuscode is the url

#@verifyPdpGetPayLoad
#Scenario: Verify that skupreviewurl was not available of requestedc commerceID in PDP Pages

#Given User should be able to navigate to home page with logged in state
#When User should be able to navigate to the books PDP page as expected
#Then Split the PDP Page url and store it in the payload to run API Test

#@VerifySkupreviewNotAvailable
#Scenario: Verify that skupreviewurl was not available of requestedc commerceID in PDP Pages

#Given Arrange the BASEURI and Required parametes for pdp page
#When Able to the hit the Post call with the arrange negative check data
#Then verify the data received for the statuscode is the pdp url


@verifytestGetPayLoad
Scenario:test
Given User should be able to navigate to test home page with logged in state
When User should be able to navigate to the test books page as expected

