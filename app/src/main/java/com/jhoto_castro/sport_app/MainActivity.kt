package com.jhoto_castro.sport_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = colorResource(id = R.color.color_primary_dark).toArgb()
            window.navigationBarColor = colorResource(id = R.color.color_primary_dark).toArgb()
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
fun SetLabelToShow(textToShow: String) {
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
        val (txtFieldUserName, txtFieldPassword, btnLogIn, spacerOne, spacerTwo, spacerThree, txtRecoverPassword) = createRefs()
        var userName by remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = userName,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.color_primary_dark),
                focusedLabelColor = colorResource(id = R.color.color_primary_dark),
                cursorColor = colorResource(id = R.color.color_primary_dark)
            ),
            onValueChange = { userName = it },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { SetLabelToShow(textToShow = stringResource(id = R.string.label_text_user_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(txtFieldUserName) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(txtFieldPassword.top)
                }
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .constrainAs(spacerOne) {
                top.linkTo(txtFieldUserName.bottom)
                start.linkTo(txtFieldUserName.start)
                end.linkTo(txtFieldUserName.end)
                bottom.linkTo(txtFieldPassword.top)
            }
        )
        var userPassword by remember { mutableStateOf(TextFieldValue()) }
        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = userPassword,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.color_primary_dark),
                focusedLabelColor = colorResource(id = R.color.color_primary_dark),
                cursorColor = colorResource(id = R.color.color_primary_dark)
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                    val iconToShow = if (!passwordVisibility) {
                        painterResource(id = R.drawable.ic_show_password)
                    } else {
                        painterResource(id = R.drawable.ic_hide_password)
                    }
                    Icon(
                        painter = iconToShow,
                        contentDescription = ""
                    )
                }
            },
            onValueChange = { userPassword = it },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { SetLabelToShow(textToShow = stringResource(id = R.string.label_text_user_password)) },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(txtFieldPassword) {
                    top.linkTo(spacerOne.bottom)
                    start.linkTo(txtFieldUserName.start)
                    end.linkTo(txtFieldUserName.end)
                }
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .constrainAs(spacerTwo) {
                top.linkTo(txtFieldPassword.bottom)
                start.linkTo(txtFieldPassword.start)
                end.linkTo(txtFieldPassword.end)
                bottom.linkTo(btnLogIn.top)
            }
        )
        Button(
            modifier = Modifier
                .constrainAs(btnLogIn) {
                    top.linkTo(spacerTwo.bottom)
                    start.linkTo(txtFieldPassword.start)
                    end.linkTo(txtFieldPassword.end)
                },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.color_primary_dark),
            ),
            onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.label_btn_log_in),
                color = colorResource(id = R.color.white)
            )
        }

    }
}