package com.geeksforgeeks.jctextfieldmaxlength

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.geeksforgeeks.jctextfieldmaxlength.ui.theme.JCTextFieldMaxLengthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("GFG | TextField Max Length", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },
        content = { MyContent() }
    )
}

@Composable
fun MyContent(){

    var mText by remember { mutableStateOf(TextFieldValue("")) }
    val mMaxLength = 5

    val mContext = LocalContext.current

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextField(
            singleLine = true,
            value = mText,
            onValueChange = {
                if (it.text.length <= mMaxLength) mText = it
                else Toast.makeText(mContext, "Cannot be more than 5 Characters", Toast.LENGTH_SHORT).show()
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}