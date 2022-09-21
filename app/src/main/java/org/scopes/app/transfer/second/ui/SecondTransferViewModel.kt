package org.scopes.app.transfer.second.ui

import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject
import kotlin.random.Random
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.scopes.app.common.di.ScreenScope
import org.scopes.app.transfer.container.domain.TransferDraft

@ScreenScope
class SecondTransferViewModel @Inject constructor(
    transferDraft: TransferDraft
) : ViewModel() {
    private val random = Random(Date().time)
    private val _uiState = MutableStateFlow(
        UiState(
            random.nextInt(0, 256),
            random.nextInt(0, 256),
            random.nextInt(0, 256),
            transferDraft.account
        )
    )
    val uiState = _uiState.asStateFlow()
}

data class UiState(val red: Int, val green: Int, val blue: Int, val account: String)