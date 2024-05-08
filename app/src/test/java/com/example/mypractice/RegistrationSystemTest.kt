package com.example.mypractice

import org.junit.Assert.*
import org.junit.Test
import com.example.mypractice.model.DocModel

class RegistrationSystemTest {

    @Test
    fun testNameValidation() {
        val validName = "John Doe"
        DocModel.name = validName
        assertEquals(validName, DocModel.name)

        // Test empty name
        assertThrows(IllegalArgumentException::class.java) {
            DocModel.name = ""
        }

        // Add more test cases for name validation as needed
    }

    @Test
    fun testEmailValidation() {
        val validEmail = "test@example.com"
        DocModel.email = validEmail
        assertEquals(validEmail, DocModel.email)

        // Test invalid email
        assertThrows(IllegalArgumentException::class.java) {
            DocModel.email = "invalid_email"
        }

        // Add more test cases for email validation as needed
    }

    // Add similar tests for phone, certID, pracID, and password validation

}
