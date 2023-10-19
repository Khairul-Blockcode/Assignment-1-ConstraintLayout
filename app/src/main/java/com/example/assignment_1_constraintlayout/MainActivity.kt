package com.example.assignment_1_constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.assignment_1_constraintlayout.ui.theme.Assignment1ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1ConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SocialMediaPost(
                        profilePicPainter = painterResource(id = R.drawable.one),
                        username = "Rivu Chakraborty",
                        timestamp = "2 hours ago",
                        postContent = "Hello, I'm Rivu Chakroborty, the first Google Developers Expert for Kotlin in India.I've ventured as a speaker and author with numerous Kotlin and Android publications under my belt. Excitingly, I've just rolled out a course on Jetpack Compose and Kotlin. Consider joining us!",
                        postPicPainter = painterResource(id = R.drawable.two
                        ),
                        likesCount = 123,
                        commentsCount = 45,
                        shareCount = 10
                    )

                }
            }
        }
    }
}

