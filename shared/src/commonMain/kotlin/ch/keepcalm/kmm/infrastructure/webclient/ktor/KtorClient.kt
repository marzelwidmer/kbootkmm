package ch.keepcalm.kmm.infrastructure.webclient.ktor

import io.ktor.client.*
import io.ktor.client.request.*

class KtorClient {
    private val client = HttpClient()

    suspend fun fetchData() : String {
        return client.get<String>{
            url("$baseUrl/posts/2")
        }
    }

    companion object {
        private const val baseUrl = "https://jsonplaceholder.typicode.com"
    }
}
