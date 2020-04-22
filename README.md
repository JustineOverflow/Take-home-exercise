# Take home exercise

You can find in this repository the completion of the test.

## My approach

### Backend

I updated the tests by adding the vehicle choices.

In the controller, I decided to use a Hashmap to store the different vehicle options (as a key) and easily access the appropriate price markup (as a value). The reason behind is to have a lookup complexity time of O(1).

After this, the tests are passing again.

### Frontend

The frontend sends the data to the server using the [axios](https://github.com/axios/axios) library and vanilla Javascript to manipulate the DOM. 

The CSS include media queries to make sure the page is responsive.

I also implemented data validation to ensure all the inputs are valid before sending the request to the server. When it is invalid, a proper message is displayed to the user.

When the submit button is clicked, the browser shows a loading animation before the server sent back the data, and without refreshing the page.

The frontend is served in the root path, which happens to be `localhost:8080` in springboot by default.

## Versions

The test has been wrote using the same versions as the initial code: Gradle 5.4.1 and Java 8.

## Thank you


