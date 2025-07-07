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
    var name: String = "",
    var email: String = "",
    var phoneNumber: String = "",
    var addressStreet: String = "",
    var addressNumber: String = "",
)

data class PaymentInfo(
    var cardNumber: String = "",
    var expiry: String = "",
    var cvv: String = "",
    var holderName: String = "",
)
