package com.junli.material_theme_setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.junli.material_theme_setting.data.ReplyHomeUIState
import com.junli.material_theme_setting.data.ReplyInboxScreen

@Composable
fun ReplyApp(
    replyHomeUIState: ReplyHomeUIState,
    closeDetailScreen: () -> Unit = {},
    navigateToDetail: (Long) -> Unit = {}
) {
    Surface(tonalElevation = 5.dp) {
        ReplyAppContent(
            replyHomeUIState = replyHomeUIState,
            closeDetailScreen = closeDetailScreen,
            navigateToDetail = navigateToDetail,
        )
    }
}

@Composable
fun ReplyAppContent(
    modifier: Modifier = Modifier,
    replyHomeUIState: ReplyHomeUIState,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long) -> Unit
) {

    val selectDestination = remember {
        mutableStateOf(ReplyRoute.INBOX)
    }

    Column(modifier = modifier.fillMaxSize()) {
        if (selectDestination.value == ReplyRoute.INBOX) {
            ReplyInboxScreen(
                replyHomeUIState = replyHomeUIState,
                closeDetailScreen = closeDetailScreen,
                navigateToDetail = navigateToDetail,
                modifier = Modifier.weight(1f)
            )
        } else {
            EmptyComingSoon()
        }

        NavigationBar(modifier = Modifier.fillMaxWidth()) {
            TOP_LEVEL_DESTINATIONS.forEach { replyDestination ->
                NavigationBarItem(
                    selected = selectDestination.value == replyDestination.route,
                    onClick = { selectDestination.value == replyDestination.route },
                    icon = {
                        Icon(
                            imageVector = replyDestination.selectedIcon,
                            contentDescription = stringResource(id = replyDestination.iconTextId)
                        )
                    })

            }
        }
    }

}

val TOP_LEVEL_DESTINATIONS = listOf(
    ReplyTopLevelDestination(
        route = ReplyRoute.INBOX,
        selectedIcon = Icons.Default.AccountBox,
        unselectedIcon = Icons.Default.AccountBox,
        iconTextId = R.string.tab_inbox
    ),
    ReplyTopLevelDestination(
        route = ReplyRoute.ARTICLES,
        selectedIcon = Icons.Default.Menu,
        unselectedIcon = Icons.Default.Menu,
        iconTextId = R.string.tab_article
    ),
    ReplyTopLevelDestination(
        route = ReplyRoute.DM,
        selectedIcon = Icons.Default.MailOutline,
        unselectedIcon = Icons.Default.MailOutline,
        iconTextId = R.string.tab_inbox
    ),
    ReplyTopLevelDestination(
        route = ReplyRoute.GROUPS,
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        iconTextId = R.string.tab_article
    )
)

object ReplyRoute {
    const val INBOX = "Inbox"
    const val ARTICLES = "Articles"
    const val DM = "DirectMessages"
    const val GROUPS = "Groups"
}

data class ReplyTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)