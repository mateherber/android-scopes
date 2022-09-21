package org.scopes.app.transfer.first.di

import dagger.Subcomponent
import org.scopes.app.common.di.ScreenScope
import org.scopes.app.transfer.first.ui.FirstTransferViewModel

@Subcomponent
@ScreenScope
interface FirstComponent {
    val viewModel: FirstTransferViewModel
}
