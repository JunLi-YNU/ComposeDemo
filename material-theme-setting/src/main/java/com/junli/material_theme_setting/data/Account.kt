package com.junli.material_theme_setting.data

import androidx.annotation.DrawableRes

data class Account(
    val id: Long,
    val uid: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val altEmail: String,
    @DrawableRes val avatar: Int,
    val isCurrentAccount: Boolean = false
) {
    val fullName: String = "$firstName $lastName"
}