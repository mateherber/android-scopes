package org.scopes.app.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

inline fun Fragment.composeView(crossinline block: @Composable () -> Unit): ComposeView {
    return ComposeView(requireActivity()).apply {
        setContent {
            ScopesTheme { block() }
        }
    }
}