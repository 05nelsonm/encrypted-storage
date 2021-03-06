package io.matthewnelson.encrypted_storage

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

/**
 * SharedPreferences helper class that allows for instantiation of either regular
 * cleartext SharedPreferences, or EncryptedSharedPreferences.
 *
 * See [Prefs.Companion.createEncrypted] and [Prefs.Companion.createUnencrypted] for
 * instantiation methods.
 * */
class Prefs private constructor(val prefsName: String, private val context: Context) {

    private lateinit var ANDX_SECURITY_KEY_KEYSET: String
    private lateinit var ANDX_SECURITY_VALUE_KEYSET: String
    private lateinit var prefs: SharedPreferences

    /**
     * Sets up [Prefs] that **does** use encryption
     * */
    private constructor(
        prefsName: String,
        context: Context,
        masterKeyAlias: String,
        prefKeyEncryptionScheme: EncryptedSharedPreferences.PrefKeyEncryptionScheme,
        prefValueEncryptionScheme: EncryptedSharedPreferences.PrefValueEncryptionScheme
    ) : this(prefsName, context) {
        ANDX_SECURITY_KEY_KEYSET = "__androidx_security_crypto_encrypted_prefs_key_keyset__"
        ANDX_SECURITY_VALUE_KEYSET = "__androidx_security_crypto_encrypted_prefs_value_keyset__"
        prefs =
            EncryptedSharedPreferences.create(
                prefsName,
                masterKeyAlias,
                context,
                prefKeyEncryptionScheme,
                prefValueEncryptionScheme
            )
    }

    init {
        if (!::ANDX_SECURITY_KEY_KEYSET.isInitialized)
            prefs = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    }

    companion object {
        const val INVALID_BOOLEAN: Boolean = false
        const val INVALID_FLOAT: Float = -11111111111F
        const val INVALID_INT: Int = -1111111111
        const val INVALID_LONG: Long = -11111111111L
        const val INVALID_STRING: String = "INVALID_STRING"
        @JvmStatic
        val INVALID_STRING_SET: Set<String> = setOf(INVALID_STRING)

        /**
         * Creates [Prefs] that will store data in an encrypted state, and decrypt
         * that data for you.
         *
         * @param [encryptedPrefsName] String
         * @param [context] Context
         *
         * @return [Prefs] that uses encryption.
         * */
        @JvmStatic
        fun createEncrypted(encryptedPrefsName: String, context: Context): Prefs =
            Prefs(
                encryptedPrefsName,
                context,
                MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )

        /**
         * Creates [Prefs] that will store data in an **un**encrypted state
         *
         * @param [prefsName] String
         * @param [context] Context
         *
         * @return [Prefs] that **does not** use encryption.
         * */
        @JvmStatic
        fun createUnencrypted(prefsName: String, context: Context): Prefs =
            Prefs(prefsName, context)
    }

    ///////////////
    // Listeners //
    ///////////////
    /**
     * Registers an onChangeListener for SharedPreferences.
     *
     * @param [listener] SharedPreferences.OnSharedPreferenceChangeListener
     * */
    fun registerOnSharedPreferenceChangeListener(
        listener: SharedPreferences.OnSharedPreferenceChangeListener
    ) {
        prefs.registerOnSharedPreferenceChangeListener(listener)
    }

    /**
     * Unregisters an onChangeListener for SharedPreferences.
     *
     * @param [listener] SharedPreferences.OnSharedPreferenceChangeListener
     * */
    fun unregisterOnSharedPreferenceChangeListener(
        listener: SharedPreferences.OnSharedPreferenceChangeListener
    ) {
        prefs.unregisterOnSharedPreferenceChangeListener(listener)
    }

    ///////////////////////
    // Read Shared Prefs //
    ///////////////////////
    /**
     * Checks if SharedPreferences contains the defined key.
     *
     * @param [key] String
     *
     * @return Boolean
     * */
    fun contains(key: String): Boolean =
        prefs.contains(key)

    /**
     * Retrieve all values from the preferences. Throws
     * a NPE if nothing exists in SharedPreferences.
     *
     * @throws [NullPointerException]
     *
     * @return Map<String, *>
     * */
    @Throws(NullPointerException::class)
    fun getAll(): Map<String, *> =
        prefs.all

    /**
     * Prior to retrieving a [Boolean] value, will check if SharedPreferences contains the key.
     * If it does not contain the key it will return **`null`** instead.
     *
     * @param [key] String
     *
     * @return Boolean **OR `null`**
     *
     * @throws [ClassCastException]
     * */
    @Throws(ClassCastException::class)
    fun read(key: String): Boolean? =
        if (contains(key))
            read(key, INVALID_BOOLEAN)
        else
            null

    /**
     * Boolean
     * */
    @Throws(ClassCastException::class)
    fun read(key: String, returnIfInvalid: Boolean): Boolean =
        prefs.getBoolean(key, returnIfInvalid)

    /**
     * Float
     * */
    @Throws(ClassCastException::class)
    fun read(key: String, returnIfInvalid: Float): Float =
        prefs.getFloat(key, returnIfInvalid)

    /**
     * Int
     * */
    @Throws(ClassCastException::class)
    fun read(key: String, returnIfInvalid: Int): Int =
        prefs.getInt(key, returnIfInvalid)

    /**
     * Long
     * */
    @Throws(ClassCastException::class)
    fun read(key: String, returnIfInvalid: Long): Long =
        prefs.getLong(key, returnIfInvalid)

    /**
     * Set<String>?
     * */
    @Throws(ClassCastException::class)
    fun read(key: String, returnIfInvalid: Set<String>): Set<String>? =
        prefs.getStringSet(key, returnIfInvalid)

    /**
     * String
     *
     * Returns a value associated with the defined key.
     * If that key does not exist in SharedPreferences,
     * the value declared for [returnIfInvalid] will be
     * returned instead.
     *
     *   - TIP: for [returnIfInvalid], see `INVALID_`
     *   constants within [Prefs.Companion] which
     *   coincides with the type of data you are
     *   querying for.
     *
     * @param [key] String
     * @param [returnIfInvalid]
     *
     * @return Returns the preference value if it exists, or returnIfInvalid. Throws
     * ClassCastException if there is a preference with this name that is not of the
     * same type you are querying for.
     *
     * @throws [ClassCastException]
     * */
    @Throws(ClassCastException::class)
    fun read(key: String, returnIfInvalid: String): String? =
        prefs.getString(key, returnIfInvalid)

    /////////////////////////
    // Modify Shared Prefs //
    /////////////////////////
    /**
     * Clears all data within SharedPreferences.
     *
     * If this method is called on the EncryptedSharedPreferences instantiation
     * of [Prefs], it will ensure that the encryption keys are replaced after
     * clearing everything else (this is due to the androidx security-crypto's
     * lack of implementation of this API call).
     *
     * @return [Prefs] for chaining multiple method calls together.
     * */
    fun clear(): Prefs {
        if (::ANDX_SECURITY_KEY_KEYSET.isInitialized) {
            val clearTextPrefs = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
            val keyKeyset = clearTextPrefs.getString(ANDX_SECURITY_KEY_KEYSET, INVALID_STRING)
            val valueKeyset =
                clearTextPrefs.getString(ANDX_SECURITY_VALUE_KEYSET, INVALID_STRING)
            if (keyKeyset != null && keyKeyset != INVALID_STRING
                && valueKeyset != null && valueKeyset != INVALID_STRING
            ) {
                if (!clearTextPrefs.edit().clear().commit()) {
                    clearTextPrefs.edit().clear().apply()
                }
                if (!clearTextPrefs.edit().putString(ANDX_SECURITY_KEY_KEYSET, keyKeyset)
                        .commit()
                ) {
                    clearTextPrefs.edit().putString(ANDX_SECURITY_KEY_KEYSET, keyKeyset).apply()
                }
                if (!clearTextPrefs.edit().putString(ANDX_SECURITY_VALUE_KEYSET, valueKeyset)
                        .commit()
                ) {
                    clearTextPrefs.edit().putString(ANDX_SECURITY_VALUE_KEYSET, valueKeyset)
                        .apply()
                }
            }
        } else {
            if (!prefs.edit().clear().commit()) {
                prefs.edit().clear().apply()
            }
        }
        return this
    }

    /**
     * Removes the key value pair associated with the defined key.
     * @param [key] String
     *
     * @return [Prefs] for chaining multiple method calls together.
     * */
    fun remove(key: String): Prefs {
        if (!prefs.edit().remove(key).commit())
            prefs.edit().remove(key).apply()
        return this
    }

    /**
     * Boolean
     * */
    fun write(key: String, value: Boolean): Prefs {
        if (!prefs.edit().putBoolean(key, value).commit())
            prefs.edit().putBoolean(key, value).apply()
        return this
    }

    /**
     * Float
     * */
    fun write(key: String, value: Float): Prefs {
        if (!prefs.edit().putFloat(key, value).commit())
            prefs.edit().putFloat(key, value).apply()
        return this
    }

    /**
     * Int
     * */
    fun write(key: String, value: Int): Prefs {
        if (!prefs.edit().putInt(key, value).commit())
            prefs.edit().putInt(key, value).apply()
        return this
    }

    /**
     * Long
     * */
    fun write(key: String, value: Long): Prefs {
        if (!prefs.edit().putLong(key, value).commit())
            prefs.edit().putLong(key, value).apply()
        return this
    }

    /**
     * Set<String>
     * */
    fun write(key: String, value: Set<String>): Prefs {
        if (!prefs.edit().putStringSet(key, value).commit())
            prefs.edit().putStringSet(key, value).apply()
        return this
    }

    /**
     * Writes the key value pair to SharedPreferences. Will *try* to
     * write the kvp using `commit()` first, which if unsuccessful, will
     * fall back to using `apply()`.
     *
     * @param [key] String
     * @param [value]
     *
     * @return [Prefs] for chaining multiple method calls together.
     * */
    fun write(key: String, value: String): Prefs {
        if (!prefs.edit().putString(key, value).commit())
            prefs.edit().putString(key, value).apply()
        return this
    }
}