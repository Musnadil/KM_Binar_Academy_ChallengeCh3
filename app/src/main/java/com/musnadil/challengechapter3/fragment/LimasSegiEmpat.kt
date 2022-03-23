package com.musnadil.challengechapter3.fragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LimasSegiEmpat(
    val nama : String? =null,
    val hasil : Double? =null,
    val panjangAlas : String? =null,
    val lebarAlas : String? =null,
    val tinggiLimas : String? =null
) :Parcelable
