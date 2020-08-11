package io.matthewnelson.encrypted_storage

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import io.matthewnelson.fake_keystore.FakeAndroidKeyStore
import org.junit.Before
import org.junit.BeforeClass
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
    private lateinit var ePrefs: Prefs
    private val appContext = ApplicationProvider.getApplicationContext<Context>()

    private companion object {
        const val PREFS = "PREFS"
        const val ENCRYPTED_PREFS = "ENCRYPTED_PREFS"

        const val BOOLEAN_KEY = "BOOLEAN_KEY"
        const val FLOAT_KEY = "FLOAT_KEY"
        const val INT_KEY = "INT_KEY"
        const val LONG_KEY = "LONG_KEY"
        const val SET_STRING_KEY = "SET_STRING_KEY"
        const val STRING_KEY = "STRING"

        @JvmStatic
        @BeforeClass
        fun beforeClass() {
            FakeAndroidKeyStore.setup
        }
    }

    @Before
    fun setup() {
        prefs = Prefs.createUnencrypted(PREFS, appContext)
        ePrefs = Prefs.createEncrypted(ENCRYPTED_PREFS, appContext)
    }

    @Test
    fun testBooleans_unencrypted() {
        testBooleans(prefs)
    }

    @Test(expected = ClassCastException::class)
    fun testBooleans_unencrypted_classCastException() {
        prefs.write(BOOLEAN_KEY, STRING_KEY)
            .read(BOOLEAN_KEY, Prefs.INVALID_BOOLEAN)
    }

    @Test
    fun testBooleans_encrypted() {
        testBooleans(ePrefs)
    }

    private fun testBooleans(prefs: Prefs) {
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

    @Test
    fun testFloats_unencrypted() {
        testFloats(prefs)
    }

    @Test(expected = ClassCastException::class)
    fun testFloats_unencrypted_classCastException() {
        prefs.write(FLOAT_KEY, STRING_KEY)
            .read(FLOAT_KEY, Prefs.INVALID_FLOAT)
    }

    @Test
    fun testFloats_encrypted() {
        testFloats(ePrefs)
    }

    private fun testFloats(prefs: Prefs) {
        var result = prefs
            .write(FLOAT_KEY, 1F)
            .read(FLOAT_KEY, Prefs.INVALID_FLOAT)
        assertEquals(1F, result)

        result = prefs
            .remove(FLOAT_KEY)
            .read(FLOAT_KEY, Prefs.INVALID_FLOAT)
        assertEquals(Prefs.INVALID_FLOAT, result)
    }

    @Test
    fun testInts_unencrypted() {
        testInts(prefs)
    }

    @Test(expected = ClassCastException::class)
    fun testInts_unencrypted_classCastException() {
        prefs.write(INT_KEY, STRING_KEY)
            .read(INT_KEY, Prefs.INVALID_INT)
    }

    @Test
    fun testInts_encrypted() {
        testInts(ePrefs)
    }

    private fun testInts(prefs: Prefs) {
        var result = prefs
            .write(INT_KEY, 1)
            .read(INT_KEY, Prefs.INVALID_INT)
        assertEquals(1, result)

        result = prefs
            .remove(INT_KEY)
            .read(INT_KEY, Prefs.INVALID_INT)
        assertEquals(Prefs.INVALID_INT, result)
    }

    @Test
    fun testLongs_unencrypted() {
        testLongs(prefs)
    }

    @Test(expected = ClassCastException::class)
    fun testLongs_unencrypted_classCastException() {
        prefs.write(LONG_KEY, STRING_KEY)
            .read(LONG_KEY, Prefs.INVALID_LONG)
    }

    @Test
    fun testLongs_encrypted() {
        testLongs(ePrefs)
    }

    private fun testLongs(prefs: Prefs) {
        var result = prefs
            .write(LONG_KEY, 1L)
            .read(LONG_KEY, Prefs.INVALID_LONG)
        assertEquals(1L, result)

        result = prefs
            .remove(LONG_KEY)
            .read(LONG_KEY, Prefs.INVALID_LONG)
        assertEquals(Prefs.INVALID_LONG, result)
    }

    @Test
    fun testStrings_unencrypted() {
        testStrings(prefs)
    }

    @Test(expected = ClassCastException::class)
    fun testStrings_unencrypted_classCastException() {
        prefs.write(STRING_KEY, 1L)
            .read(STRING_KEY, Prefs.INVALID_STRING)
    }

    @Test
    fun testStrings_encrypted() {
        testStrings(ePrefs)
    }

    private fun testStrings(prefs: Prefs) {
        var result = prefs
            .write(STRING_KEY, STRING_KEY)
            .read(STRING_KEY, Prefs.INVALID_STRING)
        assertEquals(STRING_KEY, result)

        result = prefs
            .remove(STRING_KEY)
            .read(STRING_KEY, Prefs.INVALID_STRING)
        assertEquals(Prefs.INVALID_STRING, result)
    }

    @Test
    fun testStringSets_unencrypted() {
        testStringSets(prefs)
    }

    @Test(expected = ClassCastException::class)
    fun testStringSets_unencrypted_classCastException() {
        prefs.write(SET_STRING_KEY, 1L)
            .read(SET_STRING_KEY, Prefs.INVALID_STRING_SET)
    }

    @Test
    fun testStringSets_encrypted() {
        testStringSets(ePrefs)
    }

    private fun testStringSets(prefs: Prefs) {
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

    @Test
    fun testContains_unencrypted() {
        testContains(prefs)
    }

    @Test
    fun testContains_encrypted() {
        testContains(ePrefs)
    }

    private fun testContains(prefs: Prefs) {
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
    fun testGetAll_unencrypted() {
        testGetAll(prefs)
    }

    @Test
    fun testGetAll_encrypted() {
        testGetAll(ePrefs)
    }

    private fun testGetAll(prefs: Prefs) {
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
    fun testClear_unencrypted() {
        testClear(prefs)
    }

    @Test
    fun testClear_encrypted() {
        testClear(ePrefs)
    }

    private fun testClear(prefs: Prefs) {
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
    fun testOnChangeListeners_unencrypted() {
        testOnChangeListeners(prefs)
    }

    @Test
    fun testOnChangeListeners_encrypted() {
        testOnChangeListeners(ePrefs)
    }

    private fun testOnChangeListeners(prefs: Prefs) {
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