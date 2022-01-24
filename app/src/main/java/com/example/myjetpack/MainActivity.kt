package com.example.myjetpack

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
                Text(text = "Login Activity")
            },
                actions = {
                    IconButton(onClick = { Log.d("buttion Clicked", "Clecked") }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Search")
                    }
                })

        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            item(
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(1.5f)
                        .padding(10.dp),
                    elevation = 2.dp,
                    shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp, topEnd = 20.dp, topStart = 20.dp),
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Login Form",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(20.dp)
                        )
                        Statevalue()
                        Buttons()
                    }

                }
            }
        }

    }
}

//************** State hoisting **********

// this compose is for content
@Composable
fun Statevalue() {
    var name: String by remember() {
        mutableStateOf("")
    }
    var password: String by remember() {
        mutableStateOf("")
    }
    StateFullExample(name = name, password = password, onNameChanged = { name = it })
}

//this is screen
@Composable
fun StateFullExample(name: String, password: String, onNameChanged: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChanged,
            label = { Text("Name") },
            placeholder = { Text(text = "Enter your Name") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Yellow,
                unfocusedIndicatorColor = Color.Cyan
            ),
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = password,
            onValueChange = onNameChanged,
            label = { Text("Password") },
            placeholder = { Text(text = "Enter your password") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Yellow,
                unfocusedIndicatorColor = Color.Cyan
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = false,

        )

    }
}

@Composable
fun Buttons() {
    val context = LocalContext.current
    Row() {
       Button(
            onClick = {
                showToastMessage(context =context ,"Login Done")
            },
            modifier = Modifier.padding(25.dp),
            colors = ButtonDefaults
                .buttonColors(backgroundColor = Color.Yellow),
            shape = CircleShape,
            contentPadding = PaddingValues(18.dp),
            border = BorderStroke(2.3.dp, color = Color.Yellow)

        ) {
            Text(text = "Login", fontSize = 18.sp)
        }
        TextButton(
            onClick = {},
            modifier = Modifier.padding(25.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(18.dp),
            border = BorderStroke(2.3.dp, color = Color.Yellow)

        ) {
            Text(text = "Sign Up", fontSize = 18.sp)
        }
    }
}
private fun showToastMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}