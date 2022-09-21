package org.scopes.app.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val single: Dp = 1.dp,
    val mini: Dp = 2.dp,
    val tiny: Dp = 4.dp,
    val small: Dp = 8.dp,
    val compact: Dp = 12.dp,
    val default: Dp = 16.dp,
    val roomy: Dp = 20.dp,
    val big: Dp = 24.dp,
    val bigger: Dp = 28.dp,
    val large: Dp = 32.dp,
    val larger: Dp = 36.dp,
    val xl: Dp = 40.dp,
    val xxl: Dp = 44.dp,
    val huge: Dp = 48.dp,
    val huger: Dp = 52.dp,
    val gigantic: Dp = 64.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current
