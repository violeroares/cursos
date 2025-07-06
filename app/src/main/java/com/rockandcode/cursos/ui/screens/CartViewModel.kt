package com.rockandcode.cursos.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.rockandcode.cursos.domain.models.CartItem
import com.rockandcode.cursos.domain.models.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel
    @Inject
    constructor() : ViewModel() {
        private val _items = mutableStateListOf<CartItem>()
        val items: List<CartItem> = _items

        fun addItem(item: Course) {
            if (_items.none { it.courseId == item.id }) {
                val instructors = item.instructors
                val authorText =
                    when (instructors.size) {
                        0 -> ""
                        1 -> "Por ${instructors[0].name}"
                        2 -> "Por ${instructors[0].name} y ${instructors[1].name}"
                        else -> "Por ${instructors[0].name}, ${instructors[1].name} y ${instructors.size - 2} más"
                    }

                _items.add(
                    CartItem(
                        courseId = item.id,
                        title = item.title,
                        author = authorText,
                        imageUrl = item.thumbnailUrl,
                        price = item.price,
                    ),
                )
            }
        }

        fun removeItem(courseId: Int) {
            _items.removeAll { it.courseId == courseId }
        }

//        fun clearCart() {
//            _items.clear()
//        }

        fun totalPrice(): Double = _items.sumOf { it.price }
    }
