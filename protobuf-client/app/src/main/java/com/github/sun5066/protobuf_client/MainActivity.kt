package com.github.sun5066.protobuf_client

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.sun5066.protobuf_client.ui.theme.ProtobufclientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProtobufclientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun Greeting(name: String, mainViewModel: MainViewModelV1 = viewModel()) {
    /* V1 */
    val state by mainViewModel.socketReaderFlow.collectAsStateWithLifecycle()
    if (state is SocketReadState.ReadData) {
        val person = (state as SocketReadState.ReadData).data
        Log.d("123123", "person: $person")
    }

    /* V2 */
//    Column {
//        Button(onClick = { mainViewModel.sendA("hello A world") }) {
//            Text(text = "클릭A")
//        }
//        Button(onClick = { mainViewModel.sendA("hello B world") }) {
//            Text(text = "클릭B")
//        }
//    }

    /* V3 */
//    Log.d("123123", "state: $state")
//    Column(Modifier.background(Color.Black).fillMaxSize()) {
//        Button(onClick = { mainViewModel.send() }) {
//            Text(text = "클릭")
//        }
//    }
//    mainViewModel.init()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProtobufclientTheme {
        Greeting("Android")
    }
}