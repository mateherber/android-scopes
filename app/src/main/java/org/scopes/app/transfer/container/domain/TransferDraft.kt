package org.scopes.app.transfer.container.domain

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject
import org.scopes.app.common.di.CoordinatorScope
import org.scopes.app.common.getOrSet

@CoordinatorScope
class TransferDraft @Inject constructor(private val savedStateHandle: SavedStateHandle) {
    var account: String = savedStateHandle.getOrSet(KEY_ACCOUNT) { "Empty" }
        set(value) {
            savedStateHandle[KEY_ACCOUNT] = value
            field = value
        }

    companion object {
        const val KEY_ACCOUNT = "account"
    }
}