package joseAntonioValiente.ejercicio3fragments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name: String, val mail: String, val phone: String, val image: String):Parcelable