Get Started
===

## Requirements
 - Minimum API 23

## Implementation
 - In your App module's `build.gradle` file, add the following to the `dependencies` block:
 ```groovy
 implementation 'io.matthewnelson.encrypted-storage:encrypted-storage:{{ encrypted_storage.release }}'
 ```

 - Instantiation
 ```kotlin
 // Unencrypted Prefs
 val prefs = EncryptedStorage.Prefs.createUnencrypted("MyClearTextPrefs", context)

 // Encrypted Prefs
 val encryptedPrefs = EncryptedStorage.Prefs.createEncrypted("MyEncryptedPrefs", context)

 // Encrypted File
 val encryptedFile = EncryptedStorage.File
    .createEncrypted(java.io.File("${context.filesDir.absolutePath}/MyEncryptedFile"), context))
 ```