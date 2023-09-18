package com.junli.basiclayouts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.junli.basiclayouts.ui.search_user.HomeBottomNavigation
import com.junli.basiclayouts.ui.search_user.HomeSection
import com.junli.basiclayouts.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    private val homeSection = HomeSection()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Scaffold (
                    bottomBar = {
                        val homeBottomNavigation = HomeBottomNavigation()
                        homeBottomNavigation.NewBottomNavigation(Modifier)
                    }){

                }
                homeSection.NewHomeScreen(modifier = Modifier)
            }
        }
    }
}
