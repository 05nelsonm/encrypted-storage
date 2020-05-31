[encrypted-storage](../../../index.md) / [io.matthewnelson.encrypted_storage](../../index.md) / [EncryptedStorage](../index.md) / [Prefs](index.md) / [clear](./clear.md)

# clear

`fun clear(): Prefs` [(source)](https://github.com/05nelsonm/encrypted-storage/blob/master/encrypted-storage/src/main/java/io/matthewnelson/encrypted_storage/EncryptedStorage.kt#L227)

Clears all data within SharedPreferences.

If this method is called on the EncryptedSharedPreferences instantiation
of [Prefs](index.md), it will ensure that the encryption keys are replaced after
clearing everything else (this is due to the androidx security-crypto's
lack of implementation of this API call).

**Return**
[Prefs](index.md) for chaining multiple method calls together.

