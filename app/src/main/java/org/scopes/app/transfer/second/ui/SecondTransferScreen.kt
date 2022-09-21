package org.scopes.app.transfer.second.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.scopes.app.common.CombinedPreviews
import org.scopes.app.common.ScopesPreview

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SecondTransferScreen(viewModel: SecondTransferViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SecondTransferScreen(
        uiState.red,
        uiState.green,
        uiState.blue,
        uiState.account,
    )
}

@Composable
private fun SecondTransferScreen(
    red: Int,
    green: Int,
    blue: Int,
    account: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red, green, blue)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = account)
    }
}

@CombinedPreviews
@Composable
fun SecondTransferScreenPreview() {
    ScopesPreview {
        SecondTransferScreen(10, 10, 30, "Foo")
    }
}