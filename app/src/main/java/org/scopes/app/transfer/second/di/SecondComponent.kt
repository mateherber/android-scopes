package org.scopes.app.transfer.second.di

import dagger.Subcomponent
import org.scopes.app.common.di.ScreenScope
import org.scopes.app.transfer.second.ui.SecondTransferViewModel

@Subcomponent
@ScreenScope
interface SecondComponent {
    val viewModel: SecondTransferViewModel
}
