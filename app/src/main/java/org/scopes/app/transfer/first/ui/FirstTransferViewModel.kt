package org.scopes.app.transfer.first.ui

import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject
import kotlin.random.Random
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.scopes.app.common.di.ScreenScope
import org.scopes.app.transfer.container.domain.TransferDraft

@ScreenScope
class FirstTransferViewModel @Inject constructor(
    private val transferDraft: TransferDraft
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
    private val _navigate = MutableStateFlow<Boolean?>(null)
    val navigate = _navigate.asStateFlow()

    fun accountChanged(account: String) {
        _uiState.update {
            it.copy(
                red = it.red,
                green = it.green,
                blue = it.blue,
                account = account
            )
        }
    }

    fun next() {
        transferDraft.account = uiState.value.account
        _navigate.value = true
    }

    fun clearNavigation() {
        _navigate.value = null
    }
}

data class UiState(val red: Int, val green: Int, val blue: Int, val account: String)