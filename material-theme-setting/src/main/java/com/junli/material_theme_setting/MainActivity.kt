package com.junli.material_theme_setting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.junli.material_theme_setting.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ReplyHomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState by viewModel.uiState.collectAsState()
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background,
                    tonalElevation = 50.dp
                ) {
                    ReplyApp(
                        replyHomeUIState = uiState,
                        closeDetailScreen = {
                            viewModel.closeDetailsScreen()
                        },
                        navigateToDetail = { emailId ->
                            viewModel.setSelectEmail(emailId)
                        }
                    )
                }
            }
        }
    }
}
