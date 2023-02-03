# Implemented Tasks and Changes

Invested time: about 2.5 - 3 Hours

## Non Task Changes
- Switched to data classes for entities, to automatically have hashCode and equals
- Switched from nullable vars to vals and only using nullability if really required
- Implemented basic error handling using arrow kt as an alternative to exceptions

## Implemented Tasks
### **You Talk in riddles**
Submitting an invoice with a negative price could be possible in my mind, as this
would mean that for any reason the customer gets money back. Maybe the customer
exchanged a product and bought another for a lower price, getting back the difference.

But creating invoices that are due in the past, doesn't make much sense, therefor,
the `InvoiceService` prevents this from happening by checking the due date. If
the due date is in the past, a validation failure with a corresponding message will
be returned, and the response status will be 400 Bad Request, allowing the client
to act accordingly.

### **1+1=5**
In order to prevent the client to set values from the outside, a view model is now
in place, representing the maximal set of data the client can pass to the service:

```kotlin
data class InvoiceCreationViewModel(
    val dueDate: LocalDate,
    val invoiceNumber: String,
    val quantity: BigDecimal,
    val priceNet: BigDecimal,
    val customer: Customer,
)
```

The status should always be open upon creation of the invoice, so this is a default
value in the domain model. Also, the id should not be set from the outside, along
with the creation date and the price gross. 

The price gross is calculated and stored in the database for now. This could be
further optimized to always calculate the price on the fly and making the factors
for the calculation configurable. In the setup right now, where the price gross
is stored in the database, a change in the calculation factors would require a
migration of all existing records.

### **I am curious**
The solution in place for auditing who changed what and when, is the onboard jpa
auditing. It's abstracted in a way, that an interface is in place that defines
all properties that are required for auditing. Those are the username and the 
last modification date. As soon as the user information is stored in the database,
and as soon as every user has a unique id, the setup should be modified to not reference the
user by name, but by the user id.

As long as the required auditing fields are present in the table, the solution can
be used for all tables. A rollback would be nice as well, but I would recommend
going with a different solution, described in the chapter 'Fast Forward, and I am curious - Alternative approach'

## **these are not the droids you're looking for**
Setting up spring security with basic auth, and using method security to check
if the user present, has the appropriate role for executing the underlying actions.

Right now spring security is set up with an in-memory database, to spare some time, but
this could be easily extended to a database solution.

There are two users registered right now: john and jane, both have the password doe
but different roles.

This szenario could be extended or improved by using keycloak for user management
and also api security.

## Fast Forward, and I am curious - Alternative approach
Both features could be implemented using event sourcing. This would mean to 
introduce an event store table:

```sql
create table EVENT_STORE
(
    ID varchar(128) PRIMARY KEY,
    AGGREGATE_ID BIGINT NOT NULL,
    EVENT_DATE DATETIME NOT NULL,
    AUTHOR_ID BIGINT NOT NULL,
    EVENT_KIND VARCHAR(128) NOT NULL,
    PAYLOAD TEXT NOT NULL
);
```

Every modifying request, will be an event inside this table. When the service
layer is creating the event, the model data would be json serialized and placed
into the payload column. Events are strictly immutable, so metadata of an event
will never change, and also the events themselves must never be deleted / modified.
This means that all events together, for a certain time point, will reflect the
state of the system at this point in time. As every action has an author, one
will know who issues the event, and what the changes where. It's also known when
the event was issued. As events are immutable, data already present in the system
cannot be changed, which makes the invoice an append only data structure.

After writing the event into the event store table, one would asynchronously
trigger projection building, which means, that based upon the given events of 
an aggregate, a 'standard' sql table containing the data would be created for
the 'reading' part of the application. This is done to speed up the retrieval
of information, as aggregating events could take quite some time.

### **This building looks weird**
The customer entity was contained inside the invoice domain, but really should be place inside
its own domain. The original architecture tried to implement a hexagonal approach, but seemed
to not be a 100% clean: Therefor, I rearranged the structure: Every domain package contains the
domain models and the use cases on the top level. This allows a developer to directly spot what's
done / possible in this domain, without the need to dig deeper into the package structure.
The domain service, containing the actual business logic, is placed into the service package of
a domain. As a domain could have multiple use cases, and therefor, multiple implementations,
it's a good practice to place implementations into a sub-package to keep the top level as 
simple as possible.

Everything that's connected to the outside (persistence, api), is placed into the adapter package.
This package is divided into the different parts of adapters like persistence and rest.
