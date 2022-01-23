package com.example.myjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            Display()
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

        for(i in 0..50 )
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

