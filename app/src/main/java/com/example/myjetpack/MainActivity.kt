package com.example.myjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
    Column {
        Text(
            text = "Hello This is JetPack",
            fontSize = 30.sp,
            color = Purple200,
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        SelectionContainer() {
            Text(
                text = "Hello This is JetPack ".repeat(10),
                fontSize = 30.sp,
                color = Purple200,
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                maxLines = 2
            )
        }


    }

}

