package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val challenges = arrayOf(
            "Device and OS Fragmentation",
            "Unstable and Dynamic Environment",
            "Rapid Changes",
            "Tool Support",
            "Low Tolerance"
        )
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFF073926))
            ) {
                TopBarNavigation()
                Challenges_List(challenges = challenges)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarNavigation(
) {
    val mContext = LocalContext.current
    CenterAlignedTopAppBar(
        colors = TopAppBarColors(
            containerColor = Color(0xFF0a5640),
            Color(0xFF0a5640),
            Color(0xFFffc72a),
            Color(0xFFffc72a),
            Color(0xFFffc72a)
        ),
        title = {
            Text(
                "Software Engineering Challenges",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFffc72a)
            )
        },
        navigationIcon = {
            IconButton(modifier = Modifier.size(size = 40.dp),onClick = {
                mContext.startActivity(
                    Intent(
                        mContext,
                        MainActivity::class.java
                    )
                )
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    modifier = Modifier.fillMaxSize()
                )
            }
        },
    )

}

@Composable
fun Challenges_List(challenges: Array<String>) {
    LazyColumn(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)
    ) {
        itemsIndexed(challenges) { index, challenge ->
            Challenge(index = index, title = challenge)
        }
    }
}

@Composable
fun Challenge(index: Int, title: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFffc72a),
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "#${index + 1}",
            modifier = Modifier
                .padding(start = 4.dp, top = 4.dp, end = 0.dp, bottom = 0.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF0a5640)
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF0a5640)
        )
    }
}