# sevDesk Lite - Backend

### Setup
prerequisites: installed Java 17 runtime

- Navigate to the backend directory: `cd ./lite`
- Install the dependencies: `./gradlew build`
- Start the application by running: `./gradlew bootRun`

## Exercises
- **"Tests, where?"** - `quality`
  - Maybe it's a good idea to have some tests before you change something
- **"Where is my Invoice?"** - `database`
  - Do you really think it's a good idea to just remove an invoice?
  - If yes, what's happening with the customer?
  - If no, why don't you prevent it?
- **"You talk in riddles"** - `feature`
  - Should it be possible to create an invoice with negative price?
  - or was the due date perhaps already yesterday?
- **"Give me all your money"** - `feature`
  - write an endpoint to mark an invoice paid
  - I also want to know when this happened
  - What if I don't pay the whole bill?
- **"1+1=5"** - `feature`
  - Some values should not be set from outside!
  - It's better to calculate some values  e.g. a total price
  - Don't you want to safe that total price?
- **"I am curious"** - `feature`
  - I think it would be interesting to see who changed the data and when
  - Could this be a solution, that fits all tables at once
  - Would a rollback be nice as well?
- **"Fast Forward"** - `feature`
  - Some data really should never be changed anymore. Make the Invoices an append-only data structure where every change results in a new dataset which is linked to the previous version
- **"these are not the droids you're looking for"** - `security`
  - it should be obvious, that it's a bad idea to let everyone see your invoices
  - implement some basic authorization and authentication to protect the API from unauthorized users
- **"This building looks weird"** - `architecture`
  - Is everything where it is supposed to be?
  - What are considerations to change the projects structure?
- **"I have my head in the clouds"** - `feature`
  - Everything runs on Docker today, don't it?
  - Wouldn't it be nice if frontend and backend runs on a single cluster-environment, so that you can talk to it as a single application?

### Troubleshooting and Hints
- If you use IntelliJ find in `src/test/demo.http` a few requests to quick check the functionality and to generate a first few invoices in your local DB
- you can use http://localhost:8081/h2-console/ to browse the local Database, connection-string is the one you find in the `src/resources/application.yml`
- if you use a Mac and want to connect to the generated H2-Database maybe you need to append `;OLD_INFORMATION_SCHEMA=TRUE`
