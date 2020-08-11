[encrypted-storage](../../index.md) / [io.matthewnelson.encrypted_storage](../index.md) / [Prefs](./index.md)

# Prefs

`class Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/Prefs.kt#L15)

SharedPreferences helper class that allows for instantiation of either regular
cleartext SharedPreferences, or EncryptedSharedPreferences.

See [Prefs.Companion.createEncrypted](create-encrypted.md) and [Prefs.Companion.createUnencrypted](create-unencrypted.md) for
instantiation methods.

### Properties

| Name | Summary |
|---|---|
| [prefsName](prefs-name.md) | `val prefsName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | Clears all data within SharedPreferences.`fun clear(): `[`Prefs`](./index.md) |
| [contains](contains.md) | Checks if SharedPreferences contains the defined key.`fun contains(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getAll](get-all.md) | Retrieve all values from the preferences. Throws a NPE if nothing exists in SharedPreferences.`fun getAll(): `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, *>` |
| [read](read.md) | Prior to retrieving a [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) value, will check if SharedPreferences contains the key. If it does not contain the key it will return **`null`** instead.`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?`<br>Boolean`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Float`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Int`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Long`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Set?`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<br>String`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [registerOnSharedPreferenceChangeListener](register-on-shared-preference-change-listener.md) | Registers an onChangeListener for SharedPreferences.`fun registerOnSharedPreferenceChangeListener(listener: `[`OnSharedPreferenceChangeListener`](https://developer.android.com/reference/android/content/SharedPreferences/OnSharedPreferenceChangeListener.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [remove](remove.md) | Removes the key value pair associated with the defined key.`fun remove(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Prefs`](./index.md) |
| [unregisterOnSharedPreferenceChangeListener](unregister-on-shared-preference-change-listener.md) | Unregisters an onChangeListener for SharedPreferences.`fun unregisterOnSharedPreferenceChangeListener(listener: `[`OnSharedPreferenceChangeListener`](https://developer.android.com/reference/android/content/SharedPreferences/OnSharedPreferenceChangeListener.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [write](write.md) | Boolean`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Prefs`](./index.md)<br>Float`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Prefs`](./index.md)<br>Int`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Prefs`](./index.md)<br>Long`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Prefs`](./index.md)<br>Set`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Prefs`](./index.md)<br>Writes the key value pair to SharedPreferences. Will *try* to write the kvp using `commit()` first, which if unsuccessful, will fall back to using `apply()`.`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Prefs`](./index.md) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [INVALID_BOOLEAN](-i-n-v-a-l-i-d_-b-o-o-l-e-a-n.md) | `const val INVALID_BOOLEAN: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [INVALID_FLOAT](-i-n-v-a-l-i-d_-f-l-o-a-t.md) | `const val INVALID_FLOAT: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [INVALID_INT](-i-n-v-a-l-i-d_-i-n-t.md) | `const val INVALID_INT: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [INVALID_LONG](-i-n-v-a-l-i-d_-l-o-n-g.md) | `const val INVALID_LONG: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [INVALID_STRING](-i-n-v-a-l-i-d_-s-t-r-i-n-g.md) | `const val INVALID_STRING: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [INVALID_STRING_SET](-i-n-v-a-l-i-d_-s-t-r-i-n-g_-s-e-t.md) | `val INVALID_STRING_SET: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [createEncrypted](create-encrypted.md) | Creates [Prefs](./index.md) that will store data in an encrypted state, and decrypt that data for you.`fun createEncrypted(encryptedPrefsName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Prefs`](./index.md) |
| [createUnencrypted](create-unencrypted.md) | Creates [Prefs](./index.md) that will store data in an **un**encrypted state`fun createUnencrypted(prefsName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Prefs`](./index.md) |
