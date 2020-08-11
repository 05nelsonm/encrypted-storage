package io.matthewnelson.encrypted_storage

import android.content.Context
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.security.GeneralSecurityException

/**
 * Helper class for creating encrypted Files.
 *
 * See [EFile.Companion.createEncrypted] for instantiation methods.
 * */
class EFile private constructor(
    val file: File,
    context: Context,
    val keysetAlias: String?,
    val keysetPrefName: String?
) {

    companion object {

        /**
         * Required fields only
         * */
        @Throws(GeneralSecurityException::class, IOException::class)
        fun createEncrypted(file: File, context: Context): EFile =
            EFile(file, context, null, null)

        /**
         * Required fields + custom keysetAlias
         * */
        @Throws(GeneralSecurityException::class, IOException::class)
        fun createEncrypted(file: File, context: Context, keysetAlias: String): EFile =
            EFile(file, context, keysetAlias, null)

        /**
         * Required fields + custom keysetPrefName
         * */
        @Throws(GeneralSecurityException::class, IOException::class)
        fun createEncrypted(file: File, keysetPrefName: String, context: Context): EFile =
            EFile(file, context, null, keysetPrefName)

        /**
         * Required: [file], [context]
         * Optional: [keysetAlias], [keysetPrefName]
         *
         * @param [file] java.io.File - **REQUIRED** FIELD
         * @param [context] Context - **REQUIRED** FIELD
         * @param [keysetAlias] String - **OPTIONAL** FIELD
         * @param [keysetPrefName] String - **OPTIONAL** FIELD
         *
         * @return [EFile]
         *
         * @throws [java.security.GeneralSecurityException]  when a bad master key or keyset has been used
         * @throws [java.io.IOException] when the file already exists or is not available for writing
         * */
        @Throws(GeneralSecurityException::class, IOException::class)
        fun createEncrypted(
            file: File,
            context: Context,
            keysetAlias: String,
            keysetPrefName: String
        ): EFile =
            EFile(file, context, keysetAlias, keysetPrefName)
    }

    private val encryptedFile = buildEncryptedFile(file, context, keysetAlias, keysetPrefName)

    private fun buildEncryptedFile(
        file: File,
        context: Context,
        keysetAlias: String?,
        keysetPrefName: String?
    ): EncryptedFile {
        val encryptedFileBuilder =
            EncryptedFile.Builder(
                file,
                context,
                MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
                EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
            )

        if (keysetAlias != null)
            encryptedFileBuilder.setKeysetAlias(keysetAlias)

        if (keysetPrefName != null)
            encryptedFileBuilder.setKeysetPrefName(keysetPrefName)

        return encryptedFileBuilder.build()
    }

    /**
     * Opens a FileInputStream that reads encrypted files based on the previous settings.
     *
     * Please ensure that the same master key and keyset are  used to decrypt or it
     * will cause failures.
     *
     * @return [FileInputStream] The input stream to read previously encrypted data.
     *
     * @throws [java.security.GeneralSecurityException] when a bad master key or keyset has been used
     * @throws [java.io.IOException] when the file already exists or is not available for writing
     * */
    @Throws(GeneralSecurityException::class, IOException::class)
    fun openFileInput(): FileInputStream = encryptedFile.openFileInput()

    /**
     * Opens a FileOutputStream for writing that automatically encrypts the data based on the
     * provided settings.
     *
     * Please ensure that the same master key and keyset are  used to decrypt or it
     * will cause failures.
     *
     * @return The [FileOutputStream] that encrypts all data.
     *
     * @throws [java.security.GeneralSecurityException] when a bad master key or keyset has been used
     * @throws [java.io.IOException] when the file already exists or is not available for writing
     * */
    @Throws(GeneralSecurityException::class, IOException::class)
    fun openFileOutput(): FileOutputStream = encryptedFile.openFileOutput()
}