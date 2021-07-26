package ch.keepcalm.kmm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}