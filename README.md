# EmployeeCRUD
Employee CRUD RESTful API built with spring


Launch the application

$ ./mvnw clean spring-boot:run

Read Employees

$ curl -v localhost:8080/employees

Create a new Employee

$ curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Bidyut Medhi", "role": "Asst manager"}'

Update Employee record

$ curl -X PUT localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "Manager"}'

Delete Employee

$ curl -X DELETE localhost:8080/employees/3



