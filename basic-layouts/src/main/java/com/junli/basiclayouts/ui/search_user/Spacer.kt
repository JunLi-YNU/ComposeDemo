package com.junli.basiclayouts.ui.search_user

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints

class Spacer {
    @SuppressLint("NotConstructor")
    @Composable
    @NonRestartableComposable
    fun Spacer(modifier: Modifier) {
        Layout({}, measurePolicy = SpacerMeasurePolicy, modifier = Modifier)
    }

    private object SpacerMeasurePolicy : MeasurePolicy {
        override fun MeasureScope.measure(
            measurables: List<Measurable>,
            constraints: Constraints
        ): MeasureResult {
            return with(constraints) {
                val width = if (hasFixedWidth) maxWidth else 0
                val height = if (hasFixedHeight) maxHeight else 0
                layout(width, height) {}
            }
        }
    }
}