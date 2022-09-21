package org.scopes.app.application.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.scopes.app.common.di.ViewModelKey
import org.scopes.app.transfer.first.ui.FirstTransferViewModel
import org.scopes.app.transfer.second.ui.SecondTransferViewModel

@Module
interface BindingModule {
    @Binds
    @IntoMap
    @ViewModelKey(FirstTransferViewModel::class)
    fun bindFirstTransferViewModel(firstTransferViewModel: FirstTransferViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondTransferViewModel::class)
    fun bindSecondTransferViewModel(secondTransferViewModel: SecondTransferViewModel): ViewModel
}