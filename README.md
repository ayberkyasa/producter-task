# Task for Producter
This is a GraphQL API for a basketball team and its players.

## Getting Started
Firstly, make sure that [MySQL](https://www.mysql.com/) has been downloaded on your machine on which you will run this API. After that, you have to create a database named `player` in MySQL. After creating this database, you will be ready to configure the following file:  

`src/main/resources/application.properties`

In this file, you have to fill the following field in accordance with MySQL configurations in your machine:<br> 
<b>1) {PORT_NUMBER}</b><br>
<b>2) {ROOT_USERNAME}</b><br>
<b>3) {ROOT_PASSWORD}</b><br>

Now, you are absolutely ready to run the program. After running the program, you can go to `localhost:8080/graphiql` and test the query and the mutations that you see in the Docs section on the upper right corner of the screen.