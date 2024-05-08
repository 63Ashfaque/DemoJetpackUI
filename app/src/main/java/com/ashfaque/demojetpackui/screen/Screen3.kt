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
fun Screen3() {

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
                text = "Registration",
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            //FirstName
            var fName by remember{mutableStateOf(TextFieldValue(""))}
            var fNameError by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = fName,
                onValueChange = { newText ->
                    if (newText.text.length <= 20 && newText.text.all { it.isLetter() })
                    {
                        fName = newText
                    }
                },
                label = { Text(text = "First Name") },
                maxLines = 1,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "personIcon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                isError = fNameError
            )

            //Last Name
            var lName by remember{mutableStateOf(TextFieldValue(""))}
            var lNameError by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = lName,
                onValueChange = { newText ->
                    if (newText.text.length <= 20 && newText.text.all { it.isLetter() })
                    { lName = newText }
                },
                label = { Text(text = "Last Name") },
                maxLines = 1,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "personIcon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                isError = lNameError
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

            //Mobile
            var mobile by remember{mutableStateOf(TextFieldValue(""))}
            var mobileError by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = mobile,
                onValueChange = { newText ->
                    if (newText.text.length <= 10 && newText.text.all { it.isDigit() })
                    { mobile = newText }
                },
                label = { Text(text = "Mobile") },
                maxLines = 1,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "callIcon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError = mobileError
            )


            //Mobile
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
                fNameError= fName.text.isEmpty()
                lNameError= lName.text.isEmpty()
                emailError = !isValidEmail(email.text)
                mobileError= !isValidMobile(mobile.text)
                passwordError=!isValidLength(password.text,8)

                if (!fNameError && !lNameError && !emailError && !mobileError && !passwordError) {
                    showToast(context,"Save")
                } else {
                    when {
                        fNameError -> showToast(context,"Enter the First Name")
                        lNameError -> showToast(context,"Enter the Last Name")
                        emailError -> showToast(context,"Enter the Valid Email")
                        mobileError -> showToast(context,"Enter the Valid Mobile No.")
                        passwordError -> showToast(context,"Enter the Password")
                    }
                }
            },
                modifier = Modifier.padding(16.dp)) {
                Text(text = "SAVE",
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }


        }
    }

}

