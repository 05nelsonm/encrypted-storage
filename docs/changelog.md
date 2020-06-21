# Change Log

## Version 1.0.2 (2020-06-20)

 - Removes `sealed` class modifier in lieu of a private constructor for inhibiting instantiation [[14e35dc]](https://github.com/05nelsonm/encrypted-storage/commit/14e35dc1ed2043518606c8846540702e1c18a9dc)
 - Adds espresso tests for EncryptedSharedPreferences [[b4ec5ac]](https://github.com/05nelsonm/encrypted-storage/commit/b4ec5ac7db0d879215c476b4819249aa1f56cd7b)

## Version 1.0.1 (2020-05-31)

 - Prefs.clear method now returns `this` such that chaining calls can be had [[2328a5e]](https://github.com/05nelsonm/encrypted-storage/commit/2328a5eb1a83439c427bea771793f523ba31bda4)
 - The `Prefs` class and `File` class now extend `EncryptedStorage` sealed class [[3242640]](https://github.com/05nelsonm/encrypted-storage/commit/3242640b03bdf1ef9d69d1f37cc6991e1ee8233a)
 - Updates documentation

## Version 1.0.0 (2020-05-29)

 - Initial Release