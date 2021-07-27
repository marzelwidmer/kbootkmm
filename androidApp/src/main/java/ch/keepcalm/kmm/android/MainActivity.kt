package ch.keepcalm.kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ch.keepcalm.kmm.Greeting
import android.widget.TextView
import android.widget.Toast
import ch.keepcalm.kmm.infrastructure.webclient.JsonPlaceHolderService
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        //        tv.text = greet()
        launch(Dispatchers.Main) {
                try {
                    val result =  withContext(Dispatchers.IO) {
                        JsonPlaceHolderService().getData()
                    }
                    tv.text = result
                } catch (e: Exception) {
                    Log.e("MyActivity",  e.localizedMessage)
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                }
        }
    }
}
