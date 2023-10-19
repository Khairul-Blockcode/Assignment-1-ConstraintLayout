package com.example.assignment_1_constraintlayout

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun SocialMediaPost(
    profilePicPainter: Painter,
    username: String,
    timestamp: String,
    postContent: String,
    postPicPainter: Painter,
    likesCount: Int,
    commentsCount: Int,
    shareCount:Int
) {
    val borderWidth = 3.dp
    var commentText by remember { mutableStateOf("") }
    val context = LocalContext.current
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val (pic, user, time, content, boundaryLine, image, likeBtn, commentBtn, shareBtn, progressBar, commentField,submit) = createRefs()

        val ringBrush = remember {
            Brush.sweepGradient(
                listOf(
                    Color(0xFFC913B9),
                    Color(0xFFC9373F),
                    Color(0xFFC913B9)
                )
            )
        }
        Image(
            painter = profilePicPainter,
            contentDescription = null,
            modifier = Modifier
                .constrainAs(pic) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top,8.dp)
                }
                .size(100.dp)
                .border(
                    border = BorderStroke(borderWidth, ringBrush),
                    shape = CircleShape
                )
                .padding(borderWidth + (borderWidth / 2))
                .clip(CircleShape)
        )

        Text(
            text = username,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.constrainAs(user) {
                start.linkTo(pic.end, 8.dp)
                top.linkTo(pic.top)
            }
        )

        Text(
            text = timestamp,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(time) {
                start.linkTo(user.start)
                top.linkTo(user.bottom)
            }
        )

        Text(
            text = postContent,
            textAlign = TextAlign.Justify,
            style = TextStyle(fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                letterSpacing = 0.15.sp),
            modifier = Modifier.constrainAs(content) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(pic.bottom,10.dp)
            }
        )
        Card(
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(15.dp),
            modifier = Modifier
                .height(220.dp)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(content.bottom,10.dp)
                }
        ) {
            Image(
                painter = postPicPainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().fillMaxSize()

            )
        }

        IconButton(onClick = {Toast.makeText(context, "Like Button Clicked", Toast.LENGTH_LONG).show()
            }, modifier = Modifier.background(Color.Transparent).constrainAs(likeBtn) {
                start.linkTo(parent.start)
                top.linkTo(image.bottom, 10.dp)
            }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.ThumbUp, contentDescription = null,modifier = Modifier.size(20.dp))
                    Text(text = "$likesCount",color=Color.Black)
                }
            }
        IconButton(
            onClick = {Toast.makeText(context, "Comment Button Clicked", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.background(Color.Transparent)
            .constrainAs(commentBtn) {
                start.linkTo(likeBtn.end,8.dp)
                top.linkTo(likeBtn.top)
            }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Comment, contentDescription = null,modifier = Modifier.size(20.dp))
                Text(text = "$commentsCount",color=Color.Black)
            }
        }
        IconButton(
            onClick = {Toast.makeText(context, "Share Button Clicked", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.background(Color.Transparent).constrainAs(shareBtn) {
                start.linkTo(commentBtn.end,8.dp)
                top.linkTo(commentBtn.top)
            }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Share, contentDescription = null,modifier = Modifier.size(20.dp))
                Text(text = "$shareCount",color=Color.Black)
            }
        }
        TextField(
            value = commentText ,
            label = { Text("Write Comments") },
            onValueChange = {
                commentText = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(commentField) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(shareBtn.bottom, 25.dp)
                }
        )
        Button(
         colors = ButtonDefaults.buttonColors(  Color.Black),
            onClick = {Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier
                .constrainAs(submit) {
                    start.linkTo(parent.start,250.dp)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom,1.dp)
                }
                .fillMaxWidth(.30f)
                .height(45.dp)
        ) {
            Text(
                text = "Submit",
                style = MaterialTheme.typography.bodyLarge,
                color=Color.White,
            )
        }
        }
    }

















