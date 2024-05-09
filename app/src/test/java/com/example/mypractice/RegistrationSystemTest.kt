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

    }

    @Test
    fun testPracIDValidation() {
        val validPracID = "7890"
        DocModel.pracID = validPracID
        assertEquals(validPracID, DocModel.pracID)

        // Test empty pracID
        assertThrows(IllegalArgumentException::class.java) {
            DocModel.pracID = ""
        }
    }

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
}
