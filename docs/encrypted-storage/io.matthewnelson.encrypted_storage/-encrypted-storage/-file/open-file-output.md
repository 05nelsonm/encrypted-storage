[encrypted-storage](../../../index.md) / [io.matthewnelson.encrypted_storage](../../index.md) / [EncryptedStorage](../index.md) / [File](index.md) / [openFileOutput](./open-file-output.md)

# openFileOutput

`fun openFileOutput(): `[`FileOutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/FileOutputStream.html) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L455)

Opens a FileOutputStream for writing that automatically encrypts the data based on the
provided settings.

Please ensure that the same master key and keyset are  used to decrypt or it
will cause failures.

### Exceptions

`java.security.GeneralSecurityException` - when a bad master key or keyset has been used

`java.io.IOException` - when the file already exists or is not available for writing

**Return**
The [FileOutputStream](https://docs.oracle.com/javase/6/docs/api/java/io/FileOutputStream.html) that encrypts all data.

