# Technology Description


##  Technologies used:
We were prompted to use a Java GUI, so we explored several options. We first attempted to make our project with **Spring Boot and Java Swing**, however, we found that using **JavaFX** and the idea of FXML files to style the design of the GUI as well as using Controllers for functionality, to be simpler.
We also used **Docker** to run our localhost:3306 **MYSQL** database; of which the MYSQL database information was stored in a **.env** file. 

Our DatabaseConnection.Java file was the backend that created a connection between our Docker container and our .env credentials. 



## Security Implementations
To grab and verify the Employee information from our database, we created a Employee.java file; this was the backend connecting our program to the database containing the employee's username, password, role, id, etc. It ensured that the employee logging in, would be checked and verified through our database. Otherwise, the program throws an error.



