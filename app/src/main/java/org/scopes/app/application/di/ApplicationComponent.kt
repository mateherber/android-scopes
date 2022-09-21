package org.scopes.app.application.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import org.scopes.app.application.ScopesApplication
import org.scopes.app.host.di.MainModule

@Component(modules = [AndroidInjectionModule::class, MainModule::class, BindingModule::class])
interface ApplicationComponent {
    fun inject(application: ScopesApplication)
}