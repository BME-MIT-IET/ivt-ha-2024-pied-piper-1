package com.example.mypractice.model

import org.junit.Assert.*
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AppointmentTest {

    private fun getDateFromString(dateString: String): Date {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        return format.parse(dateString)!!
    }

    @Test
    fun `test appointment initialization`() {
        // Create a date for the test
        val appointmentDate = getDateFromString("2024-12-25 15:00")

        // Initialize an Appointment object with test data
        val appointment = Appointment("John Doe", appointmentDate)

        // Assert that the properties are correctly assigned
        assertEquals("John Doe", appointment.clientName)
        assertEquals(appointmentDate, appointment.time)
    }

    @Test
    fun `test appointment property updates`() {
        // Create an initial date and an update date for the test
        val initialDate = getDateFromString("2024-12-25 15:00")
        val updatedDate = getDateFromString("2025-01-01 10:00")

        // Initialize Appointment and then update properties
        val appointment = Appointment("Jane Doe", initialDate)
        appointment.clientName = "John Smith"
        appointment.time = updatedDate

        // Assert that the properties have been updated correctly
        assertEquals("John Smith", appointment.clientName)
        assertEquals(updatedDate, appointment.time)
    }
}
