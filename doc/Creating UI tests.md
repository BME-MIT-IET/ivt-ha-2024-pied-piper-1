
## UI Tests Functionality

UI tests ensure the **usability** and **functional integrity** of the application's user interface by simulating user interactions. The tests verify that the application behaves correctly in response to user inputs. **Error handling** is checked as the application is tested for handling incorrect user inputs. **Validating proper functionality** of the visual elements of the application is done by giving correct inputs. Altogether, the tests are designed to improve **reliability, robustness, and user experience** of the application.

## UI Tests Description

### AddAppointmentTest

The test checks the functionality of the adding a new appointment by simulating  correct
and incorrect user inputs and checking system responses:

`testAppointmentCreationFlowCorrect()`: entering valid patient, date and time and
verifying the creating a new appointment process completes successfully,
transitioning from the appointments screen.
`testAppointmentCreationFlowError()`: entering valid patient,  but not entering date nor time.
Verifying the creating a new appointment process does not complete successfully,
staying on the add appointment screen.
`testBackNavigation()`: checking if click on `GoBack` button and accepting to discard changes
leads to the appointment screen.

### ExampleInstrumentedTest

A basic instrumented test, checking the application's context on an Android device:

`useAppContext()`: confirming that the app’s package name is as expected - a simple test, ensuring the application is installed and is running under the correct environment.

### LoginTest

Tests the login functionality of the application by simulating user input and checking system responses:

`testLoginSuccess()`: entering valid credentials and verifying the login process completes successfully, transitioning from the login screen.
`fun testLoginFailure()`: entering invalid credentials and verifying the login process does not succeed in this conditions.

### RegisterContactTest

The test simulates user interactions for adding contact details during registration. It involves:

`testRegisterInputAccepted()`: entering name, email, and phone number, then verifies that the correct 
activity is started upon submitting the form.
`testRegisterInputRejected()`: entering correct name and phone number, but an email in incorrect format. 
Checking that the application does not accept the wrong input and stays on the contact registration.
`testBackNavigation()`: checking the application correctly goes to the previous screen from the
Contact Registration screen.

**Example of a UI test for a correct input for Contact Registration** 
```Kotlin
@Test  
fun testRegisterInputAccepted() {  
    onView(withId(R.id.etName)).perform(click(), typeText("John"))  
    onView(withId(R.id.etEmail)).perform(click(), typeText("johndoe@email.com"))  
    onView(withId(R.id.etNumber)).perform(click(), typeText("1234567890"))  
    Espresso.closeSoftKeyboard()  
    onView(withId(R.id.btnNext)).perform(click())  
  
    // Assert that the expected Intent was fired to start RegisterID activity  
    Thread.sleep(1000)  
    Intents.intended(hasComponent(RegisterID::class.java.name))  
  
}
```


