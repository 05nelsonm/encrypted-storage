[encrypted-storage](../../index.md) / [io.matthewnelson.encrypted_storage](../index.md) / [Prefs](index.md) / [createEncrypted](./create-encrypted.md)

# createEncrypted

`@JvmStatic fun createEncrypted(encryptedPrefsName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Prefs`](index.md) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/Prefs.kt#L67)

Creates [Prefs](index.md) that will store data in an encrypted state, and decrypt
that data for you.

### Parameters

`encryptedPrefsName` - String

`context` - Context

**Return**
[Prefs](index.md) that uses encryption.

