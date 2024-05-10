package com.example.mypractice
import org.junit.Assert.*
import org.junit.Test
import com.example.mypractice.model.DocModel
import org.junit.Assert.assertEquals


class RegisterIDTest {


        @Test
        fun testCertIDAssignment() {
            // Assign a value to certID
            val expectedCertID = "123456"
            DocModel.certID = expectedCertID

            // Verify that certID was correctly set
            assertEquals(expectedCertID, DocModel.certID)
        }

        @Test
        fun testPracIDAssignment() {
            // Assign a value to pracID
            val expectedPracID = "654321"
            DocModel.pracID = expectedPracID

            // Verify that pracID was correctly set
            assertEquals(expectedPracID, DocModel.pracID)
        }

        @Test
        fun testBothIDsAssignment() {
            // Assign values to both certID and pracID
            val expectedCertID = "123456"
            val expectedPracID = "654321"
            DocModel.certID = expectedCertID
            DocModel.pracID = expectedPracID

            // Verify both fields were correctly set
            assertEquals(expectedCertID, DocModel.certID)
            assertEquals(expectedPracID, DocModel.pracID)
        }
    }



