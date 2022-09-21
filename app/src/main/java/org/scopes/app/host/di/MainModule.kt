package org.scopes.app.host.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.scopes.app.common.di.MainScope
import org.scopes.app.host.MainActivity
import org.scopes.app.transfer.container.di.TransferModule

@Module
interface MainModule {
    @MainScope
    @ContributesAndroidInjector(modules = [TransferModule::class])
    fun contributeMainAndroidInjector(): MainActivity
}
