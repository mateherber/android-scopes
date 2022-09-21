package org.scopes.app.transfer.container.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.scopes.app.common.di.CoordinatorScope
import org.scopes.app.transfer.container.TransferContainerFragment
import org.scopes.app.transfer.first.di.FirstModule
import org.scopes.app.transfer.second.di.SecondModule

@Module
interface TransferModule {
    @CoordinatorScope
    @ContributesAndroidInjector(modules = [FirstModule::class, SecondModule::class])
    fun contributeTransferAndroidInjector(): TransferContainerFragment
}