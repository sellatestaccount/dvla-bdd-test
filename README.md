# dvla-bdd-test
Scenario:

1. Open webpage : https://www.gov.uk/get-vehicle-information-from-dvla 
2. Enter Vehicle Registration
3. On the Vehicle details page assert the details (Make/Color) match with expected
output given in feature.

It's pretty simple: webdriver loads DVLA vehicle information page, enters vehicle registration number, confirms the same in vehicle enquiry page 
and verifies that the results contains the expected vehicle registration number, make and colour in the vehicle details page.

Implementation:
The project is set up such that Page Objects are implementation specific, i.e. there's a VehicleInformationPage, VehicleEnquiryServicePage
and a VehicleDetailsPage. They all need a WebDriver instance so one is injected in. 

All the dependencies are injected in Step definition and the constructor is @Autowired. This tells spring that when an instance of this step definitions class is created, 
automatically pass in (or ‘inject’) pre-created instances of whatever’s mentioned as constructor arguments.

Usage:
To run the feature :
mvn clean install

Configured to run in Chrome browser.

