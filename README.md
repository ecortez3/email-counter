#Email Counter

Service receives a list of email addresses and return a count of unique email addresses based on Google's Gmail rules.

Currently the services only functions as a GET request.

##Running the Service

A jar can be created by running 

`mvn clean package`

and service can be run by running

`java -jar target\email-counter-1.0.jar`

Making request to
`http://localhost:8080/verify-emails?emails=`

where emails are separated by commas, will return a number of unique email addresses.

###Test
Test for the utilities built can be run with

`mvn clean test`