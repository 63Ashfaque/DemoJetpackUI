package com.ashfaque.demojetpackui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashfaque.demojetpackui.R
import com.ashfaque.demojetpackui.core.isValidEmail
import com.ashfaque.demojetpackui.core.isValidLength
import com.ashfaque.demojetpackui.core.isValidMobile
import com.ashfaque.demojetpackui.core.showToast

@Preview(showBackground = true)
@Composable
fun Screen2() {

    val context =LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            Modifier.width(150.dp)
        )
        Text(text = "Company Name",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive
        )
        Spacer(Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .padding(24.dp, 8.dp, 24.dp, 8.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(
                text = "Login",
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )



            //Email
            var email by remember{mutableStateOf(TextFieldValue(""))}
            var emailError by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text(text = "Email") },
                maxLines = 1,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = emailError
            )


            //Password
            var password by remember{mutableStateOf(TextFieldValue(""))}
            var passwordError by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = password,
                onValueChange = { newText ->
                    if (newText.text.length <= 8 && newText.text.all { it.isDigit() })
                    { password = newText }
                },
                label = { Text(text = "Password") },
                maxLines = 1,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "passwordIcon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                isError = passwordError
            )


            Button(onClick = {

                emailError = !isValidEmail(email.text)
                passwordError=!isValidLength(password.text,8)

                if ( !emailError  && !passwordError) {
                    showToast(context,"Save")
                } else {
                    when {
                        emailError -> showToast(context,"Enter the Valid Email")
                        passwordError -> showToast(context,"Enter the Password")
                    }
                }
            },
                modifier = Modifier.padding(16.dp)) {
                Text(text = "Login",
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }


        }
    }

}

