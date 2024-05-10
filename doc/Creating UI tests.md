
## UI Tests Functionality

UI tests ensure the **usability** and **functional integrity** of the application's user interface by simulating user interactions. The tests verify that the application behaves correctly in response to user inputs. **Error handling** is checked as the application is tested for handling incorrect user inputs. **Validating proper functionality** of the visual elements of the application is done by giving correct inputs. Altogether, the tests are designed to improve **reliability, robustness, and user experience** of the application.

## UI Tests Description

### RegisterContactTest

The test simulates user interactions for adding contact details during registration. It involves:

**Initializing and Tearing Down**: setting up by navigating to the registration screen and cleans up by releasing resources after the test.
**Input Acceptance Test**: entering name, email, and phone number, then verifies that the correct activity is started upon submitting the form.
**Input Rejection Test**: entering correct name and phone number, but an email in incorrect format. Checking that the application does not accept the wrong input and stays on the contact registration.

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
### ExampleInstrumentedTest

A basic instrumented test, checking the application's context on an Android device:

**Context Verification**: confirming that the app’s package name is as expected - a simple test, ensuring the application is installed and is running under the correct environment.

### LoginTest

Tests the login functionality of the application by simulating user input and checking system responses:

**Login Success Test**: entering valid credentials and verifying the login process completes successfully, transitioning from the login screen.
**Login Rejection Test**: entering invalid credentials and verifying the login process does not succeed in this conditions.