package com.example.assignment_1_constraintlayout

import android.util.Log
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color


import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.constraintlayout.compose.ConstraintLayout
import kotlin.random.Random

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val random by remember { derivedStateOf { Random.nextInt() } }

    ConstraintLayout(modifier = modifier) {
        val (t1, t2, t3, t4, t5, t6) = createRefs()

        Text(
            text = "H2 Hello $name",
            modifier = Modifier.constrainAs(t3) {
                centerTo(parent)
            },
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "t1",
            modifier = Modifier.constrainAs(t6) {
                end.linkTo(t3.start, margin = 12.dp)
                top.linkTo(t3.top)
            },
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "H2 Hello $name",
            modifier = Modifier.constrainAs(t4) {
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            },
            style = MaterialTheme.typography.bodyMedium
        )

        if (random % 2 == 0) {
            Text(
                text = "H2 Hello $name",
                modifier = Modifier.constrainAs(t5) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            Text(
                text = "H200 Hello $name",
                modifier = Modifier.constrainAs(t5) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}














