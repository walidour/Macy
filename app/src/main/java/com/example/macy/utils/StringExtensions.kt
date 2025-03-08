package com.example.macy.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

fun String.hashWithSHA256(): String {
    return try {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(this.toByteArray())
        hashBytes.toHex()
    } catch (e: NoSuchAlgorithmException) {
        "" // Handle error (e.g., log it)
    }
}

// Convert byte array to hex string
private fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}