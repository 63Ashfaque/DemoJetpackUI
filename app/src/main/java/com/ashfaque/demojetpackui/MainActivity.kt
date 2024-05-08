package com.ashfaque.demojetpackui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ashfaque.demojetpackui.screen.Screen1
import com.ashfaque.demojetpackui.screen.Screen2
import com.ashfaque.demojetpackui.screen.Screen3
import com.ashfaque.demojetpackui.ui.theme.DemoJetpackUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoJetpackUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Screen3()
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoJetpackUITheme {
        Greeting()
    }
}