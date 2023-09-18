package com.junli.basiclayouts.ui.search_user

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.junli.basiclayouts.R

class AlignUserRow {
    @Composable
    fun NewAlignUser(
        @DrawableRes drawable: Int,
        @StringRes text: Int,
        modifier: Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.paddingFromBaseline(
                    top = 24.dp,
                    bottom = 8.dp
                )
            )

        }
    }


    private val alignUserBodyData = listOf(
        R.drawable.ab1_inversions to R.string.ab1_inversions,
        R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
        R.drawable.ab3_stretching to R.string.ab3_stretching,
        R.drawable.ab4_tabata to R.string.ab4_tabata,
        R.drawable.ab5_hiit to R.string.ab5_hiit,
        R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
    ).map { DrawableStringPair(it.first, it.second) }

    @Composable
    fun AlignUserBodyRow(
        modifier: Modifier
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(alignUserBodyData) { item ->
                NewAlignUser(item.drawable, item.text, modifier)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewNewAlignUser() {
        NewAlignUser(
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
    @Preview
    @Composable
    fun PreviewNewAlignUserRow(){
        AlignUserBodyRow(modifier = Modifier)
    }
}