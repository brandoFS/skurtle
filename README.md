# skurtle - Flight search Prototype
Brando Madden - 08/2016 

Instructions: 

To install, Android studio is required. It can be downloaded for free online (https://developer.android.com/studio/index.html)
you may also need to install JDK or Java libraires

Clone the Git repo to a system directory

In Android studio import the Skurtle Repo as a new Android project. 

Click the run button at the top or use the command line to build the project.

The app is very simple, starts out right on the flight search page. You can search for a flight using the flight number, airline code, and date. If results are found they will be shown on a summary page, from the summary page the user can "book" a rental car with one click. 

Libraries Used: 

*ButterKnife for Android view binding
*Gson for JSON Parsing
*Retrofit for HTTP client
*Android Support Libraries for views

Improvements:

If I had a month to work on this I would make a number of improvements. For starters I would integrate it with the existing Skurt app/archecture. I would add better validation for the fields, right now there is only simple validation if the field is empty or the date is wrong. This applies to the project as a whole but I would add Dagger2 for dependcy injection and create an API client singleton that could be called from anywhere. I would add unit and UI tests for all new code. I would add more options for flight search including the ability to search by airling name or destination if flight # is unknown. I would polish the animations and loading screens. I would add more details and probably a seprate page for the car rental process instead of a simple popup. I would add push and/or sms notifications and the ability to get updates on flight changes. I would cache the flight details so you could look at them without data connection. Would allow user to save flight searches incase they are always checking the same flight. 
