package org.scopes.app.host.di

import dagger.Subcomponent
import org.scopes.app.common.di.MainScope
import org.scopes.app.transfer.container.di.TransferComponentFactory

@Subcomponent
@MainScope
interface MainComponent : TransferComponentFactory
