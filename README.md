# Spring for GraphQL - 1.0.0

* This project will demonstrate basic implementation of GraphQL e.g. query, mutation, and subscription in Spring Boot

# Getting Started

### Sample data can be used to test this project at [URL](http://localhost:8081/graphiql?path=/graphql) 

## Query
```aidl
    {
      allUsers {
        id
        firstName
        lastName
      }
      findOne(id: 1) {
        id
        firstName
        lastName
      }
    }
```

## Mutation

```aidl
    mutation {
      addUser(user: {id: 6, firstName: "Junaid", lastName: "Dilawar"}) {
        id
      }
    }
```

## Subscription

```aidl
    subscription{
      getRandomUser {
        id
        firstName
        lastName
      }
    }
```
