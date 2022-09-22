package org.scopes.app.application

import android.app.Application
import org.scopes.app.application.di.ApplicationComponent
import org.scopes.app.application.di.DaggerApplicationComponent
import org.scopes.app.common.di.ComponentProvider

class ScopesApplication : Application(), ComponentProvider {
    override val component: ApplicationComponent by lazy { DaggerApplicationComponent.create() }
}
