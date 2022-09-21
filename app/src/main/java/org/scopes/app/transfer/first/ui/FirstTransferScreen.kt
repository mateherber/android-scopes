package org.scopes.app.transfer.first.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import org.scopes.app.common.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun FirstTransferScreen(viewModel: FirstTransferViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    FirstTransferScreen(
        uiState.red,
        uiState.green,
        uiState.blue,
        uiState.account,
        viewModel::accountChanged,
        viewModel::next
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FirstTransferScreen(
    red: Int,
    green: Int,
    blue: Int,
    account: String,
    onAccountChanged: (String) -> Unit,
    onNextClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red, green, blue)),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.default)) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Account") },
                value = account,
                onValueChange = onAccountChanged
            )
            Button(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.default)
                    .fillMaxWidth(),
                onClick = onNextClick
            ) {
                Text(text = "Next")
            }
        }
    }
}

@CombinedPreviews
@Composable
fun FirstTransferScreenPreview() {
    ScopesPreview {
        FirstTransferScreen(10, 10, 30, "Foo", {}) {}
    }
}