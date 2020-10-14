# Change Log

## Version 2.0.0 (2020-10-14)
 - Bumps Dependencies [[e5f5aa5]](https://github.com/05nelsonm/encrypted-storage/commit/e5f5aa5095b900ae2557849b63a66c14a711879c)

## Version 2.0.0 (2020-08-11)

 - BugFix: Removes equal operator from methods that return `void`[[bd98ec0]](https://github.com/05nelsonm/encrypted-storage/commit/bd98ec07f71dbe9155ad85a281ed0d13a86d3d1a)
     - Java projects were being returned `kotlin.Unit` which was causing errors.
 - Renamed the `File` class to `EFile` [[8d3c3bc]](https://github.com/05nelsonm/encrypted-storage/commit/8d3c3bc05c7a383f3ce3f707e47d4e730e62b9a7)
 - Moved the `Prefs` and `EFile` classes to their own files instead of under `EncryptedStorage`:
     - [[c010c18]](https://github.com/05nelsonm/encrypted-storage/commit/c010c180276417ef3b189309f8e3df1abc96c114)
     - [[d0d7b9b]](https://github.com/05nelsonm/encrypted-storage/commit/d0d7b9be6759ddddaed8e01409fbb2b6feaaee13)
 - Added `Throw` annotations to methods [[44f05bd]](https://github.com/05nelsonm/encrypted-storage/commit/44f05bd8d288cba7612ca3607c3aa241c6e93115)
 - Added `JvmStatic` annotations to methods/variables [[15b4159]](https://github.com/05nelsonm/encrypted-storage/commit/15b41592c9168cb88964e1eea33df459b20369ec)
 - Dependency version bumps:
     - gradle maven publish 11.1 -> 12.0 [[8b48868]](https://github.com/05nelsonm/encrypted-storage/commit/8b4886821b36d18c6917c2e98860a707c07c7770)
     - gradle 4.0.0 -> 4.0.1 [[67034a3]](https://github.com/05nelsonm/encrypted-storage/commit/67034a3c3db0d97d5a00507a9ccd3a1c601b1791)
 - Added a new module for testing purposes, to fake the AndroidKeystore.

## Version 1.0.2 (2020-06-20)

 - Removes `sealed` class modifier in lieu of a private constructor for inhibiting instantiation [[14e35dc]](https://github.com/05nelsonm/encrypted-storage/commit/14e35dc1ed2043518606c8846540702e1c18a9dc)
 - Adds espresso tests for EncryptedSharedPreferences [[b4ec5ac]](https://github.com/05nelsonm/encrypted-storage/commit/b4ec5ac7db0d879215c476b4819249aa1f56cd7b)

## Version 1.0.1 (2020-05-31)

 - Prefs.clear method now returns `this` such that chaining calls can be had [[2328a5e]](https://github.com/05nelsonm/encrypted-storage/commit/2328a5eb1a83439c427bea771793f523ba31bda4)
 - The `Prefs` class and `File` class now extend `EncryptedStorage` sealed class [[3242640]](https://github.com/05nelsonm/encrypted-storage/commit/3242640b03bdf1ef9d69d1f37cc6991e1ee8233a)
 - Updates documentation

## Version 1.0.0 (2020-05-29)

 - Initial Release