package ch.keepcalm.kmm.domain

import kotlin.jvm.JvmInline

@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotEmpty()) { "value must be non-empty" }
        require(value.trim().length >= 2) { "wrong value length" }
        require(value.trim().length <= 10) { "wrong value length" }
    }
}
