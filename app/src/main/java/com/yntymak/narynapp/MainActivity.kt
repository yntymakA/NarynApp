package com.yntymak.narynapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.yntymak.narynapp.ui.navigation.MyCityNavGraph
import com.yntymak.narynapp.ui.theme.NarynAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by rememberSaveable { mutableStateOf(true) }

            NarynAppTheme(darkTheme = isDarkTheme) {
                val windowSizeClass = calculateWindowSizeClass(this)
                MyCityNavGraph(
                    windowWidthSizeClass = windowSizeClass.widthSizeClass,
                    isDarkTheme = isDarkTheme,
                    onToggleTheme = { isDarkTheme = !isDarkTheme }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCityPreview() {
    NarynAppTheme {
        MyCityNavGraph()
    }
}