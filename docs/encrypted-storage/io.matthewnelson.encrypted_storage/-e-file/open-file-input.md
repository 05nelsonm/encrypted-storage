[encrypted-storage](../../index.md) / [io.matthewnelson.encrypted_storage](../index.md) / [EFile](index.md) / [openFileInput](./open-file-input.md)

# openFileInput

`fun openFileInput(): `[`FileInputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/FileInputStream.html) [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EFile.kt#L112)

Opens a FileInputStream that reads encrypted files based on the previous settings.

Please ensure that the same master key and keyset are  used to decrypt or it
will cause failures.

### Exceptions

`java.security.GeneralSecurityException` - when a bad master key or keyset has been used

`java.io.IOException` - when the file already exists or is not available for writing

**Return**
[FileInputStream](https://docs.oracle.com/javase/6/docs/api/java/io/FileInputStream.html) The input stream to read previously encrypted data.

