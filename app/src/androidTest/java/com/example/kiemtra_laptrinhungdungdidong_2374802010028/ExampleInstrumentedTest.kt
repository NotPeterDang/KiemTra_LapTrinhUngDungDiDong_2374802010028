package com.example.kiemtra_laptrinhungdungdidong_2374802010028

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnitRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnitRunner::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(
            "com.example.kiemtra_laptrinhungdungdidong_2374802010028",
            appContext.packageName
        )
    }
}
