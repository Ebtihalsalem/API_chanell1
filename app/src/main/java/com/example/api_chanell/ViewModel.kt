package com.example.api_chanell


//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.api_chanell.classdamoin.doiman.testone
//import io.ktor.client.call.body
//import io.ktor.client.request.get
//import kotlinx.coroutines.launch
//
///* Created by Taha https://github.com/tahaak67/ at 5/9/2024 */
//
//class ViewModel : ViewModel() {
//
//    val client = Provider.client
//
//    var sunList by mutableStateOf(emptyList<testone>())
//        private set
//
//    init {
//        viewModelScope.launch {
//            // TODO: Handle failure ex: no internet
//            sunList = client.get("https://api.sunrisesunset.io/json?lat=38.907192&lng=-77.036873&timezone=UTC&date=today").body<List<testone>>()
//        }
//    }
//
//}
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_chanell.classdamoin.doiman.testone
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    val client = Provider.client

    var sunData by mutableStateOf<testone?>(null)
        private set

    init {
        viewModelScope.launch {
            try {
                // Fetch data from the API and deserialize it into a `testone` object, not a list
                sunData = client.get("https://api.sunrisesunset.io/json?lat=38.907192&lng=-77.036873&timezone=UTC&date=today").body()
            } catch (e: Exception) {
                // Handle potential errors, such as network issues or API failures
                e.printStackTrace()
            }
        }
    }
}
