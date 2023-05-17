package com.jhoto_castro.sport_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

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
        Image(painter = painterResource(id = R.drawable.ic_logo_app),
            contentDescription = "",
            modifier = Modifier
                .padding(24.dp)
                .constrainAs(imageLogin) {
                    top.linkTo(parent.top)
                    start.linkTo(cardByFields.start)
                    end.linkTo(cardByFields.end)
                    bottom.linkTo(cardByFields.top)
                })
        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7F)
            .padding(horizontal = 32.dp)
            .background(color = Color(R.color.bg_light))
            .constrainAs(cardByFields) {
                bottom.linkTo(textVersion.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            ContentCard()
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
fun SetLabelIniTextField(textToShow: String) {
    Text(text = textToShow)
}

@Composable
fun ContentCard() {
    ConstraintLayout(
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .padding(16.dp)
            .fillMaxSize()
    ) {
        val (txtFieldUserName, textFieldPassword, btnLogIn) = createRefs()
        var userName by remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            TextFieldValue
            value = userName,
            onValueChange = { userName = it },
            label = SetLabelIniTextField(textToShow = stringResource(id = R.string.label_text_user_name)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 1,
            selectionColor = colorResource(id = R.color.color_primary_dark),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(txtFieldUserName) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}