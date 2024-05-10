package com.example.mypractice

import com.example.mypractice.model.ClientModel
import org.junit.Test
import org.junit.Assert.*
import java.util.Date

class ClientModelTest {

    @Test
    fun `test default constructor`() {
        val client = ClientModel()
        assertEquals("", client.clientId)
        assertEquals("", client.email)
        assertEquals("", client.name)
        assertEquals("", client.number)
        assertEquals(null, client.docID)
        assertEquals(null, client.dob)
    }

    @Test
    fun `test parameterized constructor`(): Unit {
        val dateOfBirth = Date()
        val client = ClientModel("1", "example@example.com", "John Doe", "1234567890", 101, dateOfBirth)

        assertEquals("1", client.clientId)
        assertEquals("example@example.com", client.email)
        assertEquals("John Doe", client.name)
        assertEquals("1234567890", client.number)
        assertEquals(101, client.docID)
        assertEquals(dateOfBirth, client.dob)
    }

    @Test
    fun `test property assignments`() {
        val client = ClientModel()
        client.clientId = "2"
        client.email = "john@doe.com"
        client.name = "John Doe"
        client.number = "987654321"
        client.docID = 102
        client.dob = Date()

        assertEquals("2", client.clientId)
        assertEquals("john@doe.com", client.email)
        assertEquals("John Doe", client.name)
        assertEquals("987654321", client.number)
        assertEquals(102, client.docID)
        assertNotNull(client.dob)
    }

}



