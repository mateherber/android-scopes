package org.scopes.app.transfer.second.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.util.*
import kotlin.random.Random
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.scopes.app.common.di.ScreenScope
import org.scopes.app.common.getOrSet
import org.scopes.app.transfer.container.domain.TransferDraft

class SecondTransferViewModel @AssistedInject constructor(
    transferDraft: TransferDraft,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val random = Random(Date().time)
    private val _uiState = MutableStateFlow(
        UiState(
            savedStateHandle.getOrSet(KEY_RED) { random.nextInt(0, 256) },
            savedStateHandle.getOrSet(KEY_GREEN) { random.nextInt(0, 256) },
            savedStateHandle.getOrSet(KEY_BLUE) { random.nextInt(0, 256) },
            transferDraft.account
        )
    )
    val uiState = _uiState.asStateFlow()

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): SecondTransferViewModel
    }

    companion object {
        const val KEY_RED = "red"
        const val KEY_GREEN = "green"
        const val KEY_BLUE = "blue"
    }
}

data class UiState(val red: Int, val green: Int, val blue: Int, val account: String)