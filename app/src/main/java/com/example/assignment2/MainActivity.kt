package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(Color(0xFF0a5640))
                    ) {
                        Greeting(
                            name = "Zach Weinzierl",
                            studentID = "1343709",
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxWidth()
                                .fillMaxHeight(0.75f)
                        )
                        BottomSection(
                            explicitBtnText = "Start Activity Explicitly",
                            implicitBtnText = "Start Activity Implicitly"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, studentID: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Name: $name",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFffc72a)
        )
        Text(
            text = "Student ID: $studentID",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFffc72a)
        )
    }
}

@Composable
fun BottomSection(explicitBtnText: String, implicitBtnText: String) {
    val mContext = LocalContext.current
    val sendIntent = Intent()
    sendIntent.setAction(Intent.ACTION_SEND)
    sendIntent.setPackage("com.example.assignment2")
    sendIntent.setType("text/plain")
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        NavButton(
            message = explicitBtnText,
            onClick = { mContext.startActivity(Intent(mContext, InfoActivity::class.java)) })
        NavButton(
            message = implicitBtnText,
            onClick = { mContext.startActivity(sendIntent) })
    }
}

@Composable
fun NavButton(message: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = Color(0xFF073926),
            contentColor = Color(0xFF073926),
            disabledContainerColor = Color(0xFF073926),
            disabledContentColor = Color(0xFF073926)
        ),
        modifier = Modifier.width(200.dp)
    ) {
        Text(
            text = message, fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFffc72a),
            textAlign = TextAlign.Center
        )
    }
}