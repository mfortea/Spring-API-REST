# Spring-API-REST
Microservice API REST created using Spring.

## API's routes
The root route for HTTP operations is "/users"

### Add an user (POST)
You can add users to the app memory sending a JSON with this structure:

```json
{
  "firstName" : "mateo",
  "lastName" : "fortea",
  "nickName" : "mfortea2",
  "password" : "pass1234",
  "email" : "mfortea@email.com",
  "country": "es"
}

```

### Get all users (GET)
You can get all users list sending a GET petition to the root route.


### Delete an user (DELETE)
You can delete one user by it nickname, you can do it sending a DELETE petition to this route "/users/nickname", 
replacing nickname for the object's nickname you want to remove.

Ex. If you want to delete "mfortea" object, the route should be:
```
/users/mfortea
```

### Modify an user (UPDATE)
You can update an user by it nickname and sending a JSON with the new object's updated data. You can also changes your actual
nickname typing the new nickname in the JSON.

Ex. If you want to update "mfortea" object, the route should be:
```
/users/mfortea
```
And the JSON with the new data:
```json
{
  "firstName": "updated",
  "lastName": "object",
  "nickName": "mfortea",
  "password" : "pass1234",
  "email": "mfortea2@email.com",
  "country": "it"
}
```

### Get users by them country (GET)
You can search all the users that have a specific country.

Ex. If you want to find all the objects with the country "es" (Spain), the route should be:
```
/users/es
```
And this returns a list with all the objects whose country is "es".


