package com.junli.basiclayouts.ui.search_user

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.junli.basiclayouts.R
import java.util.Locale

class HomeSection {

    @Composable
    fun NewHomeSection(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit

    ) {
        Column(modifier) {
            Text(
                text = stringResource(title).uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .paddingFromBaseline(20.dp)
                    .padding(16.dp)
            )
            content()
        }
    }

    @Composable
    fun NewHomeScreen(modifier: Modifier) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
        ) {
            val searchBar = SearchBar()
            val spacer = Spacer()
            spacer.Spacer(modifier.height(16.dp))
            searchBar.NewSearchBar(Modifier.padding(16.dp))
            NewHomeSection(
                title = R.string.your_friends_title,
                modifier = modifier
            ) {
                val alignUserRow = AlignUserRow()
                alignUserRow.AlignUserBodyRow(modifier = modifier)
            }
            NewHomeSection(title = R.string.favorite_collections) {
                val favorite = Favorite()
                favorite.FavoriteCollectionsGrid(modifier)
            }
            spacer.Spacer(Modifier.height(16.dp))

        }
    }

    @Preview
    @Composable
    fun PreviewNewHomeSection() {
        NewHomeSection(
            title = R.string.your_friends_title, modifier = Modifier
        ) {
            val alignUserRow = AlignUserRow()
            alignUserRow.AlignUserBodyRow(modifier = Modifier)
        }
    }
}