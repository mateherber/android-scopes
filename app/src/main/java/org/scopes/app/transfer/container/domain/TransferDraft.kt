package org.scopes.app.transfer.container.domain

import javax.inject.Inject
import org.scopes.app.common.di.CoordinatorScope

@CoordinatorScope
class TransferDraft @Inject constructor() {
    var account: String = "Empty"
}