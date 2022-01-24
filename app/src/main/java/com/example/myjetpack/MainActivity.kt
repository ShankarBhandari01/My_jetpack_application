package com.example.myjetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpack.ui.theme.Purple200


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp()
        }
    }
}

@Composable
fun Display() {
    Column(
        modifier = Modifier
            .background(color = Color.Yellow)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        // horizontalAlignment = Alignment.CenterHorizontally
    ) {

        for (i in 0..50)
            Text(
                text = "Hello This is JetPack",
                fontSize = 30.sp,
                color = Purple200,
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "This is element 1")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "This is element 2")
            Text(text = "This is element 1")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "This is element 2")
        }

    }

}

@Composable
fun LazyFunction() {
    LazyColumn(
        modifier = Modifier
            .background(color = Color.Yellow)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 100.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        //single item in lazy column
        item {
            LazyRow(

                contentPadding = PaddingValues(horizontal = 100.dp)
            ) {
                // single items
                item {
                    Text(text = "This is lazy row", fontSize = 30.sp)
                }
                items(50) { i ->
                    Text(text = "This is lamda function $i", fontSize = 40.sp)
                }

            }
        }
        items(50) { i ->
            Text(text = "This is lamda function $i", fontSize = 30.sp)
        }

    }
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize(0.5f)
            .background(color = Color.Yellow),

        ) {
        Text(text = "This is outer box elements", fontSize = 20.sp)
        Box(
            modifier = Modifier
                .fillMaxSize(0.5f)
                .background(color = Color.Blue),
        ) {
            Text(text = "This is inner box elements", fontSize = 20.sp)
        }
    }
}

@Composable
fun Myapp() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "My App")
            },
                actions = {
                    IconButton(onClick = { Log.d("buttion Clicked", "Clecked") }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                })

        }
    ) {
        Card(
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth()
                .padding(top = 40.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp),
        ) {
            StateFullExample()
        }
    }
}

@Composable
fun StateFullExample() {
    var name: String by remember() {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = name, onValueChange = {name=it}
        )
    }
}