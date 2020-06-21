[encrypted-storage](../../../index.md) / [io.matthewnelson.encrypted_storage](../../index.md) / [EncryptedStorage](../index.md) / [Prefs](index.md) / [read](./read.md)

# read

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L149)

Prior to retrieving a [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) value, will check if SharedPreferences contains the key.
If it does not contain the key it will return **`null`** instead.

### Parameters

`key` - String

### Exceptions

`ClassCastException` -

**Return**
Boolean **OR `null`**

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L158)

Boolean

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L164)

Float

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L170)

Int

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L176)

Long

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L182)

Set?

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, returnIfInvalid: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L207)

String

Returns a value associated with the defined key.
If that key does not exist in SharedPreferences,
the value declared for [returnIfInvalid](read.md#io.matthewnelson.encrypted_storage.EncryptedStorage.Prefs$read(kotlin.String, kotlin.String)/returnIfInvalid) will be
returned instead.

* TIP: for [returnIfInvalid](read.md#io.matthewnelson.encrypted_storage.EncryptedStorage.Prefs$read(kotlin.String, kotlin.String)/returnIfInvalid), see `INVALID_`
constants within [Prefs.Companion](#) which
coincides with the type of data you are
querying for.

### Parameters

`key` - String

`returnIfInvalid` -

### Exceptions

`ClassCastException` -

**Return**
Returns the preference value if it exists, or returnIfInvalid. Throws
ClassCastException if there is a preference with this name that is not of the
same type you are querying for.

