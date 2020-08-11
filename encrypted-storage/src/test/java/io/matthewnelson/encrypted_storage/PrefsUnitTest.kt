package io.matthewnelson.encrypted_storage

import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@Config(minSdk = 23, maxSdk = 28)
@RunWith(RobolectricTestRunner::class)
class PrefsUnitTest {

    private lateinit var prefs: Prefs

    private companion object {
        const val PREFS = "PREFS"

        const val BOOLEAN_KEY = "BOOLEAN_KEY"
        const val FLOAT_KEY = "FLOAT_KEY"
        const val INT_KEY = "INT_KEY"
        const val LONG_KEY = "LONG_KEY"
        const val SET_STRING_KEY = "SET_STRING_KEY"
        const val STRING_KEY = "STRING"
    }

    @Before
    fun setup() {
        prefs = Prefs.createUnencrypted(PREFS, ApplicationProvider.getApplicationContext())
    }

    @Test
    fun testBooleans() {
        var result: Boolean? = prefs.write(BOOLEAN_KEY, true)
            .read(BOOLEAN_KEY, Prefs.INVALID_BOOLEAN)
        assertEquals(true, result)

        result = prefs
            .remove(BOOLEAN_KEY)
            .read(BOOLEAN_KEY)
        assertEquals(null, result)

        result = prefs
            .write(BOOLEAN_KEY, false)
            .read(BOOLEAN_KEY)
        assertEquals(false, result)
    }

    @Test(expected = ClassCastException::class)
    fun testBooleans_classCastException() {
        prefs.write(BOOLEAN_KEY, STRING_KEY)
            .read(BOOLEAN_KEY, Prefs.INVALID_BOOLEAN)
    }

    @Test
    fun testFloats() {
        var result = prefs
            .write(FLOAT_KEY, 1F)
            .read(FLOAT_KEY, Prefs.INVALID_FLOAT)
        assertEquals(1F, result)

        result = prefs
            .remove(FLOAT_KEY)
            .read(FLOAT_KEY, Prefs.INVALID_FLOAT)
        assertEquals(Prefs.INVALID_FLOAT, result)
    }

    @Test(expected = ClassCastException::class)
    fun testFloats_classCastException() {
        prefs.write(FLOAT_KEY, STRING_KEY)
            .read(FLOAT_KEY, Prefs.INVALID_FLOAT)
    }

    @Test
    fun testInts() {
        var result = prefs
            .write(INT_KEY, 1)
            .read(INT_KEY, Prefs.INVALID_INT)
        assertEquals(1, result)

        result = prefs
            .remove(INT_KEY)
            .read(INT_KEY, Prefs.INVALID_INT)
        assertEquals(Prefs.INVALID_INT, result)
    }

    @Test(expected = ClassCastException::class)
    fun testInts_classCastException() {
        prefs.write(INT_KEY, STRING_KEY)
            .read(INT_KEY, Prefs.INVALID_INT)
    }

    @Test
    fun testLongs() {
        var result = prefs
            .write(LONG_KEY, 1L)
            .read(LONG_KEY, Prefs.INVALID_LONG)
        assertEquals(1L, result)

        result = prefs
            .remove(LONG_KEY)
            .read(LONG_KEY, Prefs.INVALID_LONG)
        assertEquals(Prefs.INVALID_LONG, result)
    }

    @Test(expected = ClassCastException::class)
    fun testLongs_classCastException() {
        prefs.write(LONG_KEY, STRING_KEY)
            .read(LONG_KEY, Prefs.INVALID_LONG)
    }

    @Test
    fun testStrings() {
        var result = prefs
            .write(STRING_KEY, STRING_KEY)
            .read(STRING_KEY, Prefs.INVALID_STRING)
        assertEquals(STRING_KEY, result)

        result = prefs
            .remove(STRING_KEY)
            .read(STRING_KEY, Prefs.INVALID_STRING)
        assertEquals(Prefs.INVALID_STRING, result)
    }

    @Test(expected = ClassCastException::class)
    fun testStrings_classCastException() {
        prefs.write(STRING_KEY, 1L)
            .read(STRING_KEY, Prefs.INVALID_STRING)
    }

    @Test
    fun testStringSets() {
        val setString = setOf(STRING_KEY + "_1", STRING_KEY + "_2", STRING_KEY + "_3")
        var result = prefs
            .write(SET_STRING_KEY, setString)
            .read(SET_STRING_KEY, Prefs.INVALID_STRING_SET)
        assertEquals(setString.toString(), result?.sorted().toString())
        assertEquals(3, result?.size)

        result = prefs
            .remove(SET_STRING_KEY)
            .read(SET_STRING_KEY, Prefs.INVALID_STRING_SET)
        assertEquals(Prefs.INVALID_STRING_SET.toString(), result.toString())
    }

    @Test(expected = ClassCastException::class)
    fun testStringSets_classCastException() {
        prefs.write(SET_STRING_KEY, 1L)
            .read(SET_STRING_KEY, Prefs.INVALID_STRING_SET)
    }

    @Test
    fun testContains() {
        var result = prefs
            .write(STRING_KEY, STRING_KEY)
            .contains(STRING_KEY)
        assertEquals(true, result)

        result = prefs
            .remove(STRING_KEY)
            .contains(STRING_KEY)
        assertEquals(false, result)
    }

    @Test
    fun testGetAll() {
        val setString = setOf(STRING_KEY + "_1", STRING_KEY + "_2", STRING_KEY + "_3")
        val bool = true
        val float = 1F
        val int = 1
        val long = 1L
        prefs.write(BOOLEAN_KEY, bool)
            .write(FLOAT_KEY, float)
            .write(INT_KEY, int)
            .write(LONG_KEY, long)
            .write(STRING_KEY, STRING_KEY)
            .write(SET_STRING_KEY, setString)

        val getAllMap = prefs.getAll()
        assertEquals(6, getAllMap.size)
        assertEquals(true, getAllMap.containsKey(BOOLEAN_KEY))
        assertEquals(bool, getAllMap[BOOLEAN_KEY])
        assertEquals(true, getAllMap.containsKey(FLOAT_KEY))
        assertEquals(float, getAllMap[FLOAT_KEY])
        assertEquals(true, getAllMap.containsKey(INT_KEY))
        assertEquals(int, getAllMap[INT_KEY])
        assertEquals(true, getAllMap.containsKey(LONG_KEY))
        assertEquals(long, getAllMap[LONG_KEY])
        assertEquals(true, getAllMap.containsKey(STRING_KEY))
        assertEquals(STRING_KEY, getAllMap[STRING_KEY])

        @Suppress("UNCHECKED_CAST")
        val setStringGet: Set<String>? = getAllMap[SET_STRING_KEY] as Set<String>?

        assertEquals(setString.toString(), setStringGet?.sorted().toString())
    }

    @Test
    fun testClear() {
        val setString = setOf(STRING_KEY + "_1", STRING_KEY + "_2", STRING_KEY + "_3")
        prefs.write(BOOLEAN_KEY, true)
            .write(FLOAT_KEY, 1F)
            .write(INT_KEY, 1)
            .write(LONG_KEY, 1L)
            .write(STRING_KEY, STRING_KEY)
            .write(SET_STRING_KEY, setString)

        var getAllMap = prefs.getAll()
        assertEquals(6, getAllMap.size)

        prefs.clear()

        getAllMap = prefs.getAll()
        assertEquals(0, getAllMap.size)
    }

    @Test
    fun testOnChangeListeners() {
        var keyOfChange: String? = null
        var retrievedValue: Any? = null

        val listener =
            SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
                keyOfChange = key
                if (key == BOOLEAN_KEY) {
                    retrievedValue = sharedPreferences.getBoolean(key, false)
                } else if (key == STRING_KEY) {
                    retrievedValue = sharedPreferences.getString(key, Prefs.INVALID_STRING)
                }
            }

        prefs.registerOnSharedPreferenceChangeListener(listener)
        prefs.write(BOOLEAN_KEY, true)
        assertEquals(BOOLEAN_KEY, keyOfChange)
        assertEquals(prefs.read(BOOLEAN_KEY), retrievedValue)

        prefs.unregisterOnSharedPreferenceChangeListener(listener)
        prefs.write(STRING_KEY, STRING_KEY)
        assertNotEquals(STRING_KEY, keyOfChange)
        assertNotEquals(prefs.read(STRING_KEY, Prefs.INVALID_STRING), retrievedValue)
    }
}