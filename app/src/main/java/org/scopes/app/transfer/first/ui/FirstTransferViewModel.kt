package org.scopes.app.transfer.first.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.util.*
import kotlin.random.Random
import kotlinx.coroutines.flow.*
import org.scopes.app.common.getOrSet
import org.scopes.app.transfer.container.domain.TransferDraft

class FirstTransferViewModel @AssistedInject constructor(
    private val transferDraft: TransferDraft,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val random = Random(Date().time)
    private val accountFlow = savedStateHandle.getStateFlow(KEY_ACCOUNT, transferDraft.account)
    val uiState = accountFlow.map { account ->
        createUiState(account)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        createUiState("")
    )

    private val _navigate = MutableStateFlow<Boolean?>(null)
    val navigate = _navigate.asStateFlow()

    fun accountChanged(account: String) {
        savedStateHandle[KEY_ACCOUNT] = account
    }

    fun next() {
        transferDraft.account = accountFlow.value
        _navigate.value = true
    }

    fun clearNavigation() {
        _navigate.value = null
    }

    private fun createUiState(account: String) = UiState(
        savedStateHandle.getOrSet(KEY_RED) { random.nextInt(0, 256) },
        savedStateHandle.getOrSet(KEY_GREEN) { random.nextInt(0, 256) },
        savedStateHandle.getOrSet(KEY_BLUE) { random.nextInt(0, 256) },
        account
    )

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): FirstTransferViewModel
    }

    companion object {
        const val KEY_RED = "red"
        const val KEY_GREEN = "green"
        const val KEY_BLUE = "blue"
        const val KEY_ACCOUNT = "account"
    }
}

data class UiState(val red: Int, val green: Int, val blue: Int, val account: String)