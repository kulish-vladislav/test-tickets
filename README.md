
# Tickets

* Create database "idea_projects"
* For same test data execute "src/main/resources/_import.sql"
* For the database connection in app, add in your system environment next variables:
   1) $DB_IDEA_USER
   2) $DB_IDEA_PASSWORD
* Starting app:
> cd impl && mvn spring-boot:run

# REST API


## Create order

### Request

`POST /tickets`

    curl -d '{"routNumber":"route","dateTime":"2019-09-25T11:30:00"}' -H "Content-Type: application/json" -X POST http://localhost:8080/tickets

### Response

    HTTP/1.1 200 
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Mon, 22 Jul 2019 22:57:56 GMT
    
    26

## Check order status

### Request

`GET /tickets/{id}/check`

    curl -i -H 'Content-Type: application/json' http://localhost:8ickets/2/check

### Response

    HTTP/1.1 200 
    Content-Type: application/json;charset=UTF-8
    Content-Length: 5
    Date: Mon, 22 Jul 2019 23:00:20 GMT
    
    ERROR