Feature: Add place to the server

@AddPlace
Scenario Outline: Add the place details to server

Given Add the baseURI with qureyprams along with "<name>" "<address>" "<phonenumber>"
When Send the https method "addPlaceAPI" and "Post" http request with the resource details
Then fecth validate the script executed and received response
And Validate the "scope" is getting "APP" as expected
And Validate the reponse "<name>" using "getPlaceAPI" method


Examples:

    |name       | address    |phonenumber|
    |Ajay       |testAddress|8787877274|

@DeletePlace
Scenario: Verify user able to delete the place details

Given Verify able to add the required body
When Send the https method "deletePlaceAPI" and "Post" http request with the resource details 
Then Validate the "status" is getting "OK" as expected 