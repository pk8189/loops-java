
## SDK Usage Examples


### Get a list of custom contact properties
Retrieve a list of your account's custom contact properties.

**API Endpoint**: `GET /contacts/customFields`


#### Example Snippet

```java
import java.util.List;

import com.loopsopenapispec.api.Client;
import com.loopsopenapispec.api.model.CustomField;

Client client = Client
                .builder()
                .withApiKey(System.getenv("API_TOKEN"))
                .build();
List<CustomField> res = client.contacts().customFields().list();
```

    
### Find a contact
Search for a contact by `email`.

**API Endpoint**: `GET /contacts/find`


#### Example Snippet

```java
import java.util.List;

import com.loopsopenapispec.api.Client;
import com.loopsopenapispec.api.model.Contact;
import com.loopsopenapispec.api.resources.contacts.find.params.ListRequest;

Client client = Client
                .builder()
                .withApiKey(System.getenv("API_TOKEN"))
                .build();
List<Contact> res = client.contacts().find().list(ListRequest
                    .builder()
                    .email("string")
                    .build());
```

    
### Create a contact
Add a contact to your audience.

**API Endpoint**: `POST /contacts/create`


#### Example Snippet

```java
import com.loopsopenapispec.api.Client;
import com.loopsopenapispec.api.model.ContactRequest;
import com.loopsopenapispec.api.model.ContactSuccessResponse;
import com.loopsopenapispec.api.resources.contacts.create.params.CreateRequest;

Client client = Client
                .builder()
                .withApiKey(System.getenv("API_TOKEN"))
                .build();
ContactSuccessResponse res = client.contacts().create().create(CreateRequest
                             .builder()
                             .data(ContactRequest
                                   .builder()
                                   .email("string")
                                   .firstName("string")
                                   .lastName("string")
                                   .subscribed(true)
                                   .userGroup("string")
                                   .userId("string")
                                   .build())
                             .build());
```

    
### Delete a contact
Delete a contact by `email` or `userId`.

**API Endpoint**: `POST /contacts/delete`


#### Example Snippet

```java
import com.loopsopenapispec.api.Client;
import com.loopsopenapispec.api.model.ContactDeleteRequest;
import com.loopsopenapispec.api.model.ContactDeleteResponse;
import com.loopsopenapispec.api.resources.contacts.delete.params.CreateRequest;

Client client = Client
                .builder()
                .withApiKey(System.getenv("API_TOKEN"))
                .build();
ContactDeleteResponse res = client.contacts().delete().create(CreateRequest
                            .builder()
                            .data(ContactDeleteRequest
                                  .builder()
                                  .email("string")
                                  .userId("string")
                                  .build())
                            .build());
```

    
### Send an event
Send events to trigger emails in Loops.<br>If a contact with the provided `email` doesn't exist, one will be created.

**API Endpoint**: `POST /events/send`


#### Example Snippet

```java
import com.loopsopenapispec.api.Client;
import com.loopsopenapispec.api.model.EventRequest;
import com.loopsopenapispec.api.model.EventSuccessResponse;
import com.loopsopenapispec.api.resources.events.send.params.CreateRequest;

Client client = Client
                .builder()
                .withApiKey(System.getenv("API_TOKEN"))
                .build();
EventSuccessResponse res = client.events().send().create(CreateRequest
                           .builder()
                           .data(EventRequest
                                 .builder()
                                 .email("string")
                                 .eventName("string")
                                 .userId("string")
                                 .build())
                           .build());
```

    
### Send a transactional email
Send a transactional email to a contact.

**API Endpoint**: `POST /transactional`


#### Example Snippet

```java
import java.util.Map;

import com.loopsopenapispec.api.Client;
import com.loopsopenapispec.api.model.TransactionalRequest;
import com.loopsopenapispec.api.model.TransactionalSuccessResponse;
import com.loopsopenapispec.api.resources.transactional.params.CreateRequest;

Client client = Client
                .builder()
                .withApiKey(System.getenv("API_TOKEN"))
                .build();
TransactionalSuccessResponse res = client.transactional().create(CreateRequest
                                   .builder()
                                   .data(TransactionalRequest
                                           .builder()
                                           .dataVariables(Map.ofEntries(

                                                   ))
                                           .email("string")
                                           .transactionalId("string")
                                           .build())
                                   .build());
```

    
### Update a contact
Update a contact by `email` or `userId`.<br>If you want to update a contact’s email address, the contact will first need a `userId` value. You can then make a request containing the userId field along with an updated email address.

**API Endpoint**: `PUT /contacts/update`


#### Example Snippet

```java
import com.loopsopenapispec.api.Client;
import com.loopsopenapispec.api.model.ContactRequest;
import com.loopsopenapispec.api.model.ContactSuccessResponse;
import com.loopsopenapispec.api.resources.contacts.update.params.PutRequest;

Client client = Client
                .builder()
                .withApiKey(System.getenv("API_TOKEN"))
                .build();
ContactSuccessResponse res = client.contacts().update().put(PutRequest
                             .builder()
                             .data(ContactRequest
                                   .builder()
                                   .email("string")
                                   .firstName("string")
                                   .lastName("string")
                                   .subscribed(true)
                                   .userGroup("string")
                                   .userId("string")
                                   .build())
                             .build());
```

    