package org.scopes.app.transfer.container.di

import dagger.Subcomponent
import org.scopes.app.common.di.CoordinatorScope
import org.scopes.app.transfer.first.di.FirstComponentFactory
import org.scopes.app.transfer.second.di.SecondComponentFactory

@Subcomponent
@CoordinatorScope
interface TransferComponent : FirstComponentFactory, SecondComponentFactory