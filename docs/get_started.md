Get Started
===

## Requirements
 - encrypted-storage
     - Minimum API 23
 - fake-keystore
     - Minimum API 16

## Implementation: Production
 - In your App module's `build.gradle` file, add the following to the `dependencies` block:
 ```groovy
 implementation 'io.matthewnelson.encrypted-storage:encrypted-storage:{{ encrypted_storage.release }}'
 ```

 - Instantiation
 ```kotlin
 // Unencrypted Prefs
 val prefs = Prefs.createUnencrypted("MyClearTextPrefs", context)

 // Encrypted Prefs
 val encryptedPrefs = Prefs.createEncrypted("MyEncryptedPrefs", context)

 // Encrypted File
 val encryptedFile = EFile.createEncrypted(File("${context.filesDir.absolutePath}/MyEncryptedFile"), context)
 ```

## Implementation: Testing
 - In your App module's `build.gradle` file, add the following to the `dependencies` block:
 ```groovy
 testImplementation 'io.matthewnelson.encrypted-storage:fake-keystore:{{ encrypted_storage.release }}'
 ```

 - Add to your unit test the following:
 ```kotlin
 companion object {
     @JvmStatic
     @BeforeClass
     fun beforeClass() {
         FakeAndroidKeyStore.setup
     }
 }
 ```

!!! Info
    Special thanks to Matthew Dolan!  
    See his Medium article regarding unit testing with Jetpack Security 
    <a href="https://proandroiddev.com/testing-jetpack-security-with-robolectric-9f9cf2aa4f61" target="_blank">here</a>