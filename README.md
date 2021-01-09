# Title

 

Rest api to manage personal notes in a multi-user environment.

 

### Requirements

 

#### Technology stack & other libraries

 

* JDK 1.8
* Spring Boot - Used to develop the api with fewer configurations and focus more on the business logic. And easy to handle crosscutting. 
        easy to manage dependency injection and provides spring data JPA to communicate with the database using ORM mapping. 
* Maven - Project Management Tool(easy to handle dependencies
* Database - MySQL

 


#### Libraries and Plugins

 

* Lombok - Never write another getter or equals method again, with one annotation a class has a fully-featured builder, Automate the logging variables, and much more.
* Swagger - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

 

Swagger ui url = /swagger-ui.html
Using this interface, all the api end points can be checked. 

 


#### External Tools & Services

 

* Postman - API Development Environment (Testing Documentation)

 


### How to bootstrap this API:

 

There are several ways to run a Spring Boot application on your local machine. 

 

* One way is to execute the main method in the lk.company.notesmanagementAPI.NotesManagementApplication class from your IDE.

 

* Alternatively you can use the Spring Boot Maven plugin like so:

 

      mvn spring-boot:run

 

Then automatically spring data jpa will create the database called "notesmanagement" having user table, note table, and note_archive table

 

* User table (User table should be filled manually for testing purpose)

 

|  id | user_name |
| :--:| :--: |
| U001 | Kamal |
| U002 | Amal |

 

 

## All details about API Endpoints

 

### 1. Save a new note 
URL: 
/api/v1/notes/

 

Http method:
POST

 

Data Params:
the body should be:
```json
{
     noteId="N001",
   description="message",
     userId="U001"
}
```

 

Success Response:
```json
{
Code: 200
message : "true! saved successfully"
data: {null}
}
```

 

Error Response:
```json
{
Code: 500
message : "false"
data: { error : like "already exists"}
}
```

 


### 2. Update a previously saved note
URL:
/api/v1/notes/

 

Http method:
PUT

 

Data Params:
the body should be:
```json
    {
     noteId="N001",
         description="message",
     userId="U001"
    }
```
Success Response:
```json
Code: 200
message : "true! updated successfully"
data: {null}
```
Error Response:
```json
Code: 500
message : "false"
data: { error : like "such a note doesn't exist"}
```

 


### 3. Delete a saved note
URL:
/api/v1/notes/

 

Http method:
DELETE

 

URL Params:
?noteId="N001"

 

Success Response:
```json
Code: 200
message : "true! deleted successfully"
data: {null}
```
Error Response:
```json
Code: 500
message : "false"
data: { error : like "such a note doesn't exists"}
```

 

### 4. Archive a note
URL:
/api/v1/notes/archive

 

Http method:
PUT

 

URL Params:
?noteId="N001"

 

Success Response:
```json
Code: 200
message : "true! archived successfully"
data: {null}
```
Error Response:
```json
Code: 500
message : "false"
data: { error : like "such a note doesn't exist"}
```

 

### 5. Unarchive a previously archived note
URL:
/api/v1/notes/unarchive

 

Http method:
PUT

 

URL Params:
?noteId="N001"

 

Success Response:
```json
Code: 200
message : "true! unarchived successfully"
data: {null}
```
Error Response:
```json
Code: 500
message : "false"
data: { error : like "such a note doesn't exist"}
```

 

### 6. List saved notes that aren't archived
URL:
/api/v1/notes/

 

Http method:
GET

 

Success Response:
```json
Code: 200
message : "true"
data: {Note json objects of all notes without archive notes}
```
Error Response:
```json
Code: 500
message : "false"
data: { error : }
```

 

### 7.List notes that are archived
URL:
/api/v1/notes/archivednotes

 

Http method:
GET

 

Success Response:
```json
Code: 200
message : "true"
data: {Note json objects of all archive notes}
```
Error Response:
```json
Code: 500
message : "false"
data: { error : }
```
