[encrypted-storage](../../../index.md) / [io.matthewnelson.encrypted_storage](../../index.md) / [EncryptedStorage](../index.md) / [File](./index.md)

# File

`class File` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L334)

Helper class for creating encrypted Files.

See [File.Companion.createEncrypted](create-encrypted.md) for instantiation methods.

### Properties

| Name | Summary |
|---|---|
| [file](file.md) | `val file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html) |
| [keysetAlias](keyset-alias.md) | `val keysetAlias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [keysetPrefName](keyset-pref-name.md) | `val keysetPrefName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| [openFileInput](open-file-input.md) | Opens a FileInputStream that reads encrypted files based on the previous settings.`fun openFileInput(): `[`FileInputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/FileInputStream.html) |
| [openFileOutput](open-file-output.md) | Opens a FileOutputStream for writing that automatically encrypts the data based on the provided settings.`fun openFileOutput(): `[`FileOutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/FileOutputStream.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [createEncrypted](create-encrypted.md) | Required fields only`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): File`<br>Required fields + custom keysetAlias`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, keysetAlias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): File`<br>Required fields + custom keysetPrefName`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, keysetPrefName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): File`<br>Required: [file](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/file), [context](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/context) Optional: [keysetAlias](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/keysetAlias), [keysetPrefName](create-encrypted.md#io.matthewnelson.encrypted_storage.EncryptedStorage.File.Companion$createEncrypted(java.io.File, android.content.Context, kotlin.String, kotlin.String)/keysetPrefName)`fun createEncrypted(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, keysetAlias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, keysetPrefName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): File` |
