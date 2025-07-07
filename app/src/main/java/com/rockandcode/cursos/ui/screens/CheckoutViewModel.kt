package com.rockandcode.cursos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rockandcode.cursos.domain.models.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel
    @Inject
    constructor() : ViewModel() {
        var userInfo by mutableStateOf(UserInfo())
        var paymentInfo by mutableStateOf(PaymentInfo())
        var coursesToBuy by mutableStateOf<List<Course>>(emptyList())

        fun setCourses(courses: List<Course>) {
            coursesToBuy = courses
        }

        fun reset() {
            userInfo = UserInfo()
            paymentInfo = PaymentInfo()
            coursesToBuy = emptyList()
        }

        fun isOnlyFreeCourses(): Boolean = coursesToBuy.isNotEmpty() && coursesToBuy.all { it.price == 0.0 }
    }

data class UserInfo(
    var name: String = "Natalia Mucci",
    var email: String = "nataliaemucci@qmail.com",
    var phoneNumber: String = "1130033007",
    var addressStreet: String = "Arieta",
    var addressNumber: String = "250",
)

data class PaymentInfo(
    var cardNumber: String = "41234123412341234",
    var expiry: String = "09/26",
    var cvv: String = "123",
    var holderName: String = "99999999",
)
