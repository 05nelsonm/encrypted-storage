[encrypted-storage](../../../index.md) / [io.matthewnelson.encrypted_storage](../../index.md) / [EncryptedStorage](../index.md) / [Prefs](index.md) / [write](./write.md)

# write

`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L275)

Boolean

`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L285)

Float

`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L295)

Int

`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L305)

Long

`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L315)

Set

`fun write(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L332)

Writes the key value pair to SharedPreferences. Will *try* to
write the kvp using `commit()` first, which if unsuccessful, will
fall back to using `apply()`.

### Parameters

`key` - String

`value` -

**Return**
[Prefs](index.md) for chaining multiple method calls together.

