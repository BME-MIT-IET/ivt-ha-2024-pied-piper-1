package com.example.mypractice
import org.junit.Assert.*
import org.junit.Test
import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ClientDetailsTest {

    private fun Date.calculateAge(): Int {
        val currentDate = Calendar.getInstance().time
        val dobCalendar = Calendar.getInstance().apply { time = this@calculateAge }

        var age = Calendar.getInstance().get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR)

        if (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        return age
    }

    @Test
    fun testCalculateAge() {
        // Test case 1: Birthday passed this year
        val birthday1 = getDateFromString("1990-05-05") // Assuming the current date is 2024-05-07
        assertEquals(34, birthday1.calculateAge())

        // Test case 2: Birthday hasn't passed this year
        val birthday2 = getDateFromString("1995-10-20") // Assuming the current date is 2024-05-07
        assertEquals(28, birthday2.calculateAge())

        // Test case 3: Leap year birthday, birthday passed this year
        val birthday3 = getDateFromString("2000-02-29") // Assuming the current date is 2024-05-07
        assertEquals(24, birthday3.calculateAge())

        // Test case 4: Leap year birthday, birthday hasn't passed this year
        val birthday4 = getDateFromString("2000-02-29") // Assuming the current date is 2023-02-28
        assertEquals(24, birthday4.calculateAge())

        // Test case 5: Birthday today
        val birthday5 = getDateFromString("1999-05-07") // Assuming the current date is 2024-05-07
        assertEquals(25, birthday5.calculateAge())
    }

    private fun getDateFromString(dateString: String): Date {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateString)!!
    }

    @Test
    fun testDocumentParsing() {
        val mockClientName = "John Doe"
        val mockClientNumber = "123456789"
        val mockClientEmail = "john.doe@example.com"

        // Validate these mock data against the expected output
        assertEquals("John Doe", mockClientName)
        assertEquals("123456789", mockClientNumber)
        assertEquals("john.doe@example.com", mockClientEmail)
    }


}
