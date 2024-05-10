## Unit Tests Functionality

Unit test ensure **internal logic** of the application is correct by running 
individual methods and functions in isolation to ensure that each component 
works correctly by itself. This checks **functional integrity** of the application. 
**Error handling** is also tested by checking the responses to incorrect inputs.
Altogether it improves **reliability and robustness** of the application.


## Unit Tests Description

### RegistrationSystemTest
The test validates fields related to user registration within the `DocModel` class. It includes:

**Name Validation**: checking proper assignment of names, rejecting empty names.
**Email Validation**: checking the validity of the email format -accepting the right 
ones and rejecting invalid ones.
**PracID Validation**: checking that the practitioner ID is accepted when valid and 
rejecting empty IDs.
**Password Validation**: checking password requirements including length, presence 
of special characters, and numerals.


### ClientDetailsTest
The test validates the correctness of storing and retrieving client details. It includes:

**Client Name Test**: checking and verifying the proper storage of a client's name.
**Client Number Test**: checking the handling and storage of a client's contact number.
**Client Email Test**: checking and ensuring the client's email is correctly stored and retrieved.

### ExampleUnitTest

The test contains basic arithmetic operations to demonstrate the setup of unit tests:

**Addition Test**:  checking and validating the correctness of a simple addition operation.

###  RegisterIDTest

The test checks the assignment and validation of identification numbers specifically 
within the `DocModel`. It includes:

**CertID Assignment Test**: checking and ensuring that certification IDs are correctly assigned and stored.
**PracID Assignment Test**: checking similar to the CertID test, but for practitioner IDs.
**Both IDs Assignment Test**: checking and verifying the simultaneous assignment of both 
certification and practitioner IDs.

**Test for correct name input:**
```Kotlin
@Test
    fun testNameValidation() {
        val validName = "John Doe"
        DocModel.name = validName
        assertEquals(validName, DocModel.name)

        // Test empty name
        assertThrows(IllegalArgumentException::class.java) {
            DocModel.name = ""
        }
    }
```
