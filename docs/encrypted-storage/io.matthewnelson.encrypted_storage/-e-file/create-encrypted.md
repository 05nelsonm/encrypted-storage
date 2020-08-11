[encrypted-storage](../../index.md) / [io.matthewnelson.encrypted_storage](../index.md) / [EFile](index.md) / [createEncrypted](./create-encrypted.md)

# createEncrypted

`@JvmStatic fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`EFile`](index.md) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EFile.kt#L31)

Required fields only

`@JvmStatic fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, keysetAlias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EFile`](index.md) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EFile.kt#L39)

Required fields + custom keysetAlias

`@JvmStatic fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, keysetPrefName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`EFile`](index.md) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EFile.kt#L47)

Required fields + custom keysetPrefName

`@JvmStatic fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, keysetAlias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, keysetPrefName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EFile`](index.md) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EFile.kt#L66)

Required: [file](create-encrypted.md#io.matthewnelson.encrypted_storage.EFile.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/file), [context](create-encrypted.md#io.matthewnelson.encrypted_storage.EFile.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/context)
Optional: [keysetAlias](create-encrypted.md#io.matthewnelson.encrypted_storage.EFile.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/keysetAlias), [keysetPrefName](create-encrypted.md#io.matthewnelson.encrypted_storage.EFile.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/keysetPrefName)

### Parameters

`file` - java.io.File - **REQUIRED** FIELD

`context` - Context - **REQUIRED** FIELD

`keysetAlias` - String - **OPTIONAL** FIELD

`keysetPrefName` - String - **OPTIONAL** FIELD

### Exceptions

`java.security.GeneralSecurityException` - when a bad master key or keyset has been used

`java.io.IOException` - when the file already exists or is not available for writing

**Return**
[EFile](index.md)

