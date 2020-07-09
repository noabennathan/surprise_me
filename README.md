"# surprise_me" 

build:
build the JAR file with ./mvnw clean package

run:
run the built JAR file/the one attached in my email, as follows:
java -jar target/rest-service-0.0.1-SNAPSHOT.jar

use the API:
to get a new surprise:
go to http://localhost:8080/surprise?name=YourFullName&birth_year=XXX
enter your data, for exmaple, if your name is "Israel Israeli" and birth year is 1985 do this:
go to http://localhost:8080/surprise?name=IsraelIsraeli&birth_year=1985
to get the stats go to:
http://localhost:8080/stats