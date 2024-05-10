## Unit Tests Functionality

Unit test ensure **internal logic** of the application is correct by running 
individual methods and functions in isolation to ensure that each component 
works correctly by itself. This checks **functional integrity** of the application. 
**Error handling** is also tested by checking the responses to incorrect inputs.
Altogether it improves **reliability and robustness** of the application.


## Unit Tests Description

### AppointmentTest
The test verifying functionality of 'Appointment' - correct property initialisation
and updates.

`test appointment initialization`: checking correct initialisation of 'Appointment' object
with specified values for the constructor
`test appointment property updates`: checking the correct updates for the already created 
`Appointment` object.


### ClientDetailsTest
The test validates the correctness of storing and retrieving client details. It includes:

`testCalculateAge`: validating custom extension method `calculateAge()` for the `Date` class.
`testDocumentParsing`: checking and verifying the proper storage of the client's name, 
handling of the contact number and email.


### ClientModelTest

The test validates the functionality of ClientModel:

`test default constructor`: verifying the constructor works with the default values
(empty strings and nulls)

`test parameterized constructor`: verifying the constructor works with specified values

`test property assignments`: verifying assigning properties to the ClientModel,
after it was created


### ExampleUnitTest

The test contains basic arithmetic operations to demonstrate the setup of unit tests:

`addition_isCorrect`:  checking and validating the correctness of a simple addition operation.


###  RegisterIDTest

The test checks the assignment and validation of identification numbers specifically
within the `DocModel`. It includes:

`testCertIDAssignment`: checking and ensuring that certification IDs are correctly assigned and stored.
`testPracIDAssignment`: checking similar to the CertID test, but for practitioner IDs.
`testBothIDsAssignment`: checking and verifying the simultaneous assignment of both
certification and practitioner IDs.

### RegistrationSystemTest
The test validates fields related to user registration within the `DocModel` class. It includes:

`testNameValidation`: checking proper assignment of names, rejecting empty names.
`testEmailValidation`: checking the validity of the email format -accepting the right
ones and rejecting invalid ones.
`testPracIDValidation`: checking that the practitioner ID is accepted when valid and
rejecting empty IDs.
`testPasswordValidation`: checking password requirements including length, presence
of special characters, and numerals.

**Example of a unit test for a passward validation:**
```Kotlin
@Test
fun testPasswordValidation() {
    val validPassword = "P@ssw0rd"
    DocModel.password = validPassword
    assertEquals(validPassword, DocModel.password)

    // Test empty password
    assertThrows(IllegalArgumentException::class.java) {
        DocModel.password = ""
    }

    // Test password less than 8 characters
    assertThrows(IllegalArgumentException::class.java) {
        DocModel.password = "12345"
    }

    // Test password without special characters
    assertThrows(IllegalArgumentException::class.java) {
        DocModel.password = "Password123"
    }

    // Test password without digits
    assertThrows(IllegalArgumentException::class.java) {
        DocModel.password = "Password@"
    }
}
```
