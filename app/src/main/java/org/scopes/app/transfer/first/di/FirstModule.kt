package org.scopes.app.transfer.first.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.scopes.app.common.di.ScreenScope
import org.scopes.app.transfer.first.ui.FirstTransferFragment

@Module
interface FirstModule {
    @ScreenScope
    @ContributesAndroidInjector
    fun contributeFirstAndroidInjector(): FirstTransferFragment
}