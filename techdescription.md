# Technology Description

## Guidelines to Follow
Build an executable program or a cloud-based web application.

##  Technologies used:

We first attempted to make our project with **Spring Boot/Spring**; however, we found that if we wanted to package our program into a executable .jar or .exe file rather than a web app (therefore, eliminating client-based work), then we'd need to use a GUI that'd support that. We moved on to try Java Swing, but making our program responsive wasn't easy. That was when we discovered **JavaFX** and using SceneBuilder to build FXML files that would style the design(s) of the GUI's, making the sizing and positionings of components a whole lot easier. The concept of Controllers and Event Listeners for functionality were also made much simpler.
We also used **Docker** to run our localhost:3306 **MYSQL** database; of which the MYSQL database information was stored in a **.env** file. 

Our DatabaseConnection.Java file was the backend that established a connection between our Docker container and our .env credentials. 



## Security Implementations
To grab and verify the Employee information from our database, we created a Employee.java file; this was the backend connecting our program to the database containing the employee's username, password, role, id, etc. It ensured that the employee logging in, would be checked and verified through our database. Otherwise, the program would throw an error.



