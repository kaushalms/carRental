# carRental

Car Rental search 
Tool: Android studio
API: Hotwire

The app shows popular destinations listed on the main fragment. User can click on the search floating button to enter user defined destination and time period. On clicking OK, another intent with the result opens in a listview. Currently, the items in the listview is not clickable but can be implemented by fetching data using the deeplink from the initial JSON request. 
- Libraries used in this project are okhttp, retrofit and material design. 
- okhttp and retrofit were used to establish connection with the API and fetch result based on the GET request. -
- The incoming JSON result is parsed into appropriate models using the respective getters and setters. 
- Once the data is in and parsed, it is then added to the list view using an adapter. 
