package com.example.api_chanell

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.lazy.items
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.api_chanell.classdamoin.doiman.Results
import com.example.api_chanell.classdamoin.doiman.testone
import com.example.api_chanell.ui.theme.API_chanellTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            API_chanellTheme {

                ScreenOneContent()

            }
        }
    }
}

@Composable
fun ScreenOneContent(modifier: Modifier = Modifier) {
    val viewModel: ViewModel = viewModel()

    if (viewModel.sunData == null) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize(),
            color = androidx.compose.ui.graphics.Color.Blue
        )
    } else {
        val sunData = viewModel.sunData
        if (sunData != null) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    SunItem(
                        modifier = Modifier.fillMaxWidth(),
                        results = sunData.results,
                        status = sunData.status
                    )
                }
            }
        }
    }
}

@Composable
fun SunItem(modifier: Modifier = Modifier, results: Results, status: String) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
           // .shadow(8.dp) // Optional shadow for depth effect
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Sunrise: ${results.sunrise}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Sunset: ${results.sunset}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = "Day Length: ${results.dayLength}",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Status: $status",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}



