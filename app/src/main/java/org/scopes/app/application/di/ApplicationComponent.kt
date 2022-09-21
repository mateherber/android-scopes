package org.scopes.app.application.di

import dagger.Component
import javax.inject.Singleton
import org.scopes.app.host.di.MainComponentFactory

@Component
@Singleton
interface ApplicationComponent : MainComponentFactory