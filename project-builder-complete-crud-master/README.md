![Image description](https://i1.faceprep.in/ProGrad/face-logo-resized.png)

# ProGrad Project Builder | Connecting with DATABASE

## A Quick Introduction

This lab will be completely based on your week-4 Java project.

## What should you do
```
Fork this repo
Clone this repo
Practice Java basics - operators, conditions, loops, class and object
```

## How To Submit
```
Upon completion, run the following commands:

git add .
git commit -m "ProGrad ID"
git push origin master

And finally, create a pull request so your ProGrad Mentor (PM) can review your work.
```

## Instructions

1. ***Read the instructions carefully***
2. ***Controller class called as Main should go inside the controller package.***
3. ***Your database connection code should exist inside the utlity package.***
4. ***Your crud operations should go inside the dao package.***
5. ***Your validation and business logic should go inside service package.***
6. ***Once the progressions are completed follow the instructions to run the application and test your code.***
7. ***Add appropriate jars to your project directory.***

## Requirements
Download ojdbc6.jar from the given link [https://www.oracle.com/database/technologies/jdbcdriver-ucp-downloads.html]
.***

## PROGRESSION :
- Complete your entire week - 4 project into a database project. This means, you need to implement all the modules with the use of databases. 

Build module by module and finish up the project.

![Image description](https://i1.faceprep.in/ProGrad/sql-module.gif)
 
## Run the Project
1. Right click on the project.
2. Go to Run as -> Run as Java Application.
3. You can check the output in eclipse console.

### Note:

Use the below code to retreive the connection details from jdbc.properties to establish connection
```
public static Properties loadPropertiesFile() throws Exception {
	Properties prop = new Properties();	
	InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
	prop.load(in);
	in.close(); 
	return prop;
}
```
Create a file called as jdbc.properites. To create a file right click on the application - new - file - name the file as jdbc.properties.
```
jdbc.properties
#JDBC properties entry for ORACLE server
driver = oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:xe
username=your_username
password=your_password

```

Happy Coding ❤️
