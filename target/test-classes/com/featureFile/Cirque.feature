Feature: Cirque Healthcare! Application it has managing the patients treatment process
@login
Scenario: User was login into the Application
Given User launch the URL "https://cirque.sgssys.info/login"
When Verify the User has been navigated to Application login page
And User enter the Username name into Username field
And Enter Invalid Username and Valid Password
And Enter Valid Username and Invalid Password
And Click on the login Button
Then Employer navigated to Employer Dashboard page

@Add
Scenario: User Navigated to Account Manager Menu and Add New Account Manager
Given User Click the Account Manager Menu
When User click the Add Account Manager button
And User enter input into the Last and First Name fields
And User enter input into the Phone Number and Email address fields
And User Choose the Commission Type
And User Click the close Icon to get the Confirmation Popup
And Enter the Account Manager details
And Click the Add button to create the Account Manager

@Add
Scenario: Edit Account Manager Information
And Download the Excel and PDF files
And Search the added Account Manager listed in the resultant Grid 
And User click the Edit the Account Manager Details
And User Click the close Icon to getting the Confirmation popup
And User again Click Edit icon to change the Account Manager informations
Then User Update the Account Manager Details

@Add
Scenario: User Navigated to Service Location Menu and Add Service Location
Given User click the Service Location Menu
When User click the Add New Service Location button
And User enter location input into Location Name field 
And User enter the Location Address1 and Address2
And User enter the input into City field
And User Select the value from State dropdown
And User enter the input into zip code and Phone number fields
And User enter the input into email and Website URL fields
And User select the Account Manager and Procedures value from the dropdown
And User choose the Service logo 
And User Click to close the Add Service location popup
And User again Enter the Service Location details
And Click the Add button to create the Service Location

@Add
Scenario: Edit Service Location Information in Service Location Menu
And Download the service location Excel and PDF files 
And User click the Edit the Service Location Details
And User again Click Edit icon to change the Service Location informations
Then User Update the Service Location Details

@Add
Scenario: User can able to assign the form to service location in Manage Form Menu
Given User Click to navigate Manage Form menu
When User click View Icon to view the Forms
And User click to Edit the Forms
And User Assign the Service Location 
And User Update the assigned service Location

@Add
Scenario: User Can add new provider in Manage Providers Menu
Given User Click to navigate Manage Providers menu 
And User click the Add Manager Providers button
And User enter the provider Last Name and First Name
And User select the provider suffix from the dropdown field
And User enter the provider Phone Number and Email address
And User select the provider State from the dropdown field.
And User enter the provider Medical License Number and NPI number
And User provider mapping the Account Manager from the dropdown field
And User check the Cancel Confirmation popup is displayed
And user Add the New Provider account

@Add
Scenario: Edit Provider Information in Manage Providers Menu
Given Download to Export Providers List to Excel and PDF files 
When User click the Edit button from the provider Grid list
And User again Click Edit icon to change the Provider informations
Then User Update the Provider Details


Scenario: User can able to send Patient Registration Invite Link in Manage Patient Menu
Given User click the Manage Patients Menu to redirected to manage patient page
And User click the Add Manager patients button
And User select the Service Location Name from the dropdown field
And User select the Provider Name from the dropdown field
And User select the Account Manager Name from the dropdown field
And User enter the Patient Last Name and First Name
And User select the Patient DOB from the Date picker
And User enter the Patient Phone Number and Email Address
And User select the Procedure Name from the dropdown field
And User Select the invite sharing Preference
And User Close the Add Patient Popup 
And User Click the Share Link button
Then User Check the Invite has been received to Patient email address


Scenario: Patient was Login into Patient Registration Portal
Given Patient Click the Registration Invite Link
And Patient Enter the Last Name into LastName field
And Patient Enter the DOB into DOB field
And Patient click to verify button
Then Patient should navigate to Patient Registration Page 


Scenario: Patient was entering the Patient Information details
Given patient entering patient SSN and Address
When Patient entering city and Select state from the dropdown
And Patient entering Zipcode and Modify the Phone and Email
And Select is patient a minor radio button 
And Patient click the same As checkbox  and unchecked up the sameAs checkbox
And Patient entering Parent or Legal Guardian information
And Patient select the insurance information radio button
And Entering Patient Insurance information details
And User checkedUp the confirm this information is accurate checkbox
And patient entering digital signature
And Patient moved to next form tab by clicking the next button
And User Entering the Digital signature 
And Click the Prev button to check the Patient Informations
And Click the Proceed to Pay to redirected to payment Page
And User Enter payment card details
And User click the Pay button
Then Patient should navigate the Payment Status page


Scenario: Admin Login the Application to verify the Patient payment transaction was successed
Given User navigated to Manage payment Menu
When User click the Manage Payment Menu
And User pick the From date and To date from the Date Picker
And User filtering the Payment list by using Date Range filter
And User Click the Search button to filter the data
And User Click the Reset button to get all the datas
And User flitering the data by using Quick search options
And User Click the Payment receipt download icon
Then User Exporting the payment lists to Excel and PDF file


Scenario: User Check the Patient Census Lists in Census List Menu
Given User click Census List Menu to redirected to Census List Page
When User flitering the Pending Census data by using Quick search options
And User click the Edit Status icon in the Grid list
And User change the Patient Status From the dropdown
And User click Update button to change the Patient Status
And User check the Changed Patient data moved to completed Grid list
And User flitering the Completed Census data by using Quick search options
Then User Exporting the Census lists to Excel and PDF file

Scenario: User can change the Password by themselves 
Given User click Settings menu to redirected to Change Password Page
When User click entering Old Password into Old Password field
And User entering the New Password into New Password Field
And User entering the Confirm New Password into Confirm New Password Field
And User check the New and Confirm New Password field with invalid input
And User check the New and Confirm New Password field with valid input
And User check the Confirmation Popup is presented
And User check the successfully logged out from the Application after click the ok button
And User verify the Login with old password
And User verify the login with newly changed Password
Then User should be logged in to Application



