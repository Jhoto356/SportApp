package com.jhoto_castro.sport_app

import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintMain()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ConstraintMain() {
    ConstraintLayout(
        modifier = Modifier
            .background(color = colorResource(id = R.color.color_primary_dark))
            .fillMaxSize()
    ) {
        val (cardByFields, textVersion, imageLogin) = createRefs()
//       Image(painter = , contentDescription = , modifier = Modifier.constrainAs(imageLogin))
        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 88.dp, horizontal = 32.dp)
            .background(color = Color(R.color.bg_light))
            .constrainAs(cardByFields) {
                top.linkTo(parent.top)
                bottom.linkTo(textVersion.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {

        }
        Text(
            text = stringResource(id = R.string.version_app),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .constrainAs(textVersion) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(cardByFields.start)
                    end.linkTo(cardByFields.end)
                }, style = TextStyle(
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun ContentCard() {

}