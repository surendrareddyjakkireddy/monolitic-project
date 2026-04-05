       # microservices-project
                 +----------------------+
                 |  Eureka Server       |
                 | (Service Registry)   |
                 +----------+-----------+
                            |
        -----------------------------------------
        |                                       |
+----------------------+         +----------------------+
| Student Service      |         | Course Service       |
| (Eureka Client)      |         | (Eureka Client)      |
+----------------------+         +----------------------+
**school-student-service Http methods** 
PUT
/api/student/updateStudent

POST
/api/student/createStudent

GET
/api/student/getFlux

GET
/api/student/getEnrollment

GET
/api/student/findById

GET
/api/student/findAll

DELETE
/api/student/delete

**school-course-service Http methods**
PUT
/api/course/update

PUT
/api/course/updateEnrolment

POST
/api/course/create

POST
/api/course/createEnrollment

GET
/api/course/findById

GET
/api/course/findAll

GET
/api/course/findAllEnrollment

DELETE
/api/course/delete
