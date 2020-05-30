[encrypted-storage](../../../index.md) / [io.matthewnelson.encrypted_storage](../../index.md) / [EncryptedStorage](../index.md) / [File](index.md) / [createEncrypted](./create-encrypted.md)

# createEncrypted

`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): File` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L358)

Required fields only

`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, keysetAlias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): File` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L367)

Required fields + custom keysetAlias

`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, keysetPrefName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): File` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L377)

Required fields + custom keysetPrefName

`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, keysetAlias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, keysetPrefName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): File` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L398)

Required: [file](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/file), [context](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/context)
Optional: [keysetAlias](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/keysetAlias), [keysetPrefName](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/keysetPrefName)

### Parameters

`file` - java.io.File - **REQUIRED** FIELD

`context` - Context - **REQUIRED** FIELD

`keysetAlias` - String - **OPTIONAL** FIELD

`keysetPrefName` - String - **OPTIONAL** FIELD

### Exceptions

`java.security.GeneralSecurityException` - when a bad master key or keyset has been used

`java.io.IOException` - when the file already exists or is not available for writing

**Return**
[EncryptedStorage.File](index.md)

