package com.github.sun5066

import java.nio.charset.Charset
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

fun String.decrypt(key: String): String {
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    val keyBytes = ByteArray(16)
    val b = key.toByteArray(charset("UTF-8"))
    var len = b.size

    if (len > keyBytes.size) len = keyBytes.size
    System.arraycopy(b, 0, keyBytes, 0, len)

    val keySpec = SecretKeySpec(keyBytes, "AES")
    val ivSpec = IvParameterSpec(keyBytes)
    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)

    val results = cipher.doFinal(Base64.getDecoder().decode(this))

    return String(results, Charset.defaultCharset())
}

fun String.encrypt(key: String): String {
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    val keyBytes = ByteArray(16)
    val b = key.toByteArray(charset("UTF-8"))
    var len = b.size

    if (len > keyBytes.size) len = keyBytes.size
    System.arraycopy(b, 0, keyBytes, 0, len)

    val keySpec = SecretKeySpec(keyBytes, "AES")
    val ivSpec = IvParameterSpec(keyBytes)
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)

    val results = cipher.doFinal(this.toByteArray(charset("UTF-8")))

    return Base64.getEncoder().encodeToString(results)
}