# sevDesk Lite - UI

### Setup
- Clone and checkout the main repository: https://gitlab.com/sevdesk/recruting_case.git
- Navigate to the ui directory: `cd ./lite-ui`
- Install the required dependencies: `npm install`
- Start the application by running: `npm run dev`

### Exercises
- **"Wrong turn"** - `feature`
  - Implement a "Not found" page that tells users they navigated to a route that does not exist. Create a fullscreen splash page.
    Provide them a way to navigate back to the main page

- **"Great! Now what?"** - `feature`
  - Give the user feedback after he tries to submit a new invoice. Present a message for success or error and send him to the updated list view, if he successfully creates a new invoice.
- **"The burning of harrenhal"** - `feature`
  - Enable the user to delete invoices from the invoice list view - add another column to the table including a button that triggers a delete action
  - You can use the API Endpoint "DELETE `/invoices/{id}`"
- **"Je ne parle pas anglais"** - `feature`
  - We have discovered, that a lot of people from france are interested in using our product. Create a solution to display translated values of labels, heading, copy text etc. inside the app. Use this solution to translate the text found in the invoice form and it's corresponding route. Translations can be found in the "translations" folder
- **"He's just a little shy"** - `feature`
  - The page "Top Secret" contains some highly confidential information. It should only be available to admin users. Hide the corresponding navigation item if a user is not an admin. Prevent all navigation to the corresponding route and show the user a hint that he is not allowed to access it.
- **"It's all about DX"** - `feature`
  - Creating a new react component is tedious. Create a new folder, create the component file, the styles file, the test file... Create a way to generate a bare bones component by supplying the name via the command line, to skip all the boilerplate code. Hint: You can use the following library https://www.hygen.io/ or come up with a way of your own
- **"Which way is up again?"** - `feature`
  - Enable sorting of the invoice table by each existing column. Include an indicator next to the column header to let the user know which column is sorted by and by which direction. Only one column can be sorting the rows at a time.
- **"Make it pretty"** - `feature`
  - Replace the status text inside the invoice table with fitting icons to representn the state. You can use the icon library already installed: https://tabler-icons.io/
- **"Wait, do I know you?"** - `feature` `frontend + backend`
  - Build a way to create and reuse customers when writing a new invoice
- **"Are you still eating that?"** - `feature`
  - Whenever a user wants to navigate away from invoice editing without saving a document prompt him to confirm his action we don't want him / her to loses progress.
  - Add another option to the prompt to save the data temporarily and load it once he comes back to the editing mask.