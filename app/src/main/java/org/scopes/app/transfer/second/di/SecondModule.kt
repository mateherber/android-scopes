package org.scopes.app.transfer.second.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.scopes.app.common.di.ScreenScope
import org.scopes.app.transfer.second.ui.SecondTransferFragment

@Module
interface SecondModule {
    @ScreenScope
    @ContributesAndroidInjector
    fun contributeSecondAndroidInjector(): SecondTransferFragment
}