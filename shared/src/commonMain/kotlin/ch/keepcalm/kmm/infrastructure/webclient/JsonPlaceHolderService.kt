package ch.keepcalm.kmm.infrastructure.webclient

import ch.keepcalm.kmm.infrastructure.webclient.ktor.KtorClient

class JsonPlaceHolderService {

    suspend fun getData() : String {
        val data = KtorClient().fetchData()
        return "Data from API: $data"
    }
}
