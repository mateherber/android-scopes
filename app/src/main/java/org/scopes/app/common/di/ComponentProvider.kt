package org.scopes.app.common.di

interface ComponentProvider<T : Any> {
    val component: T
}