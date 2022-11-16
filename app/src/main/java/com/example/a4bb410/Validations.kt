package com.example.a4bb410

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.PatternSyntaxException

fun String.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.length >= 8
}