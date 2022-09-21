package org.scopes.app.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.scopes.app.common.di.ComponentProvider
import org.scopes.app.common.di.Factory

inline fun Fragment.composeView(crossinline block: @Composable () -> Unit): ComposeView {
    return ComposeView(requireActivity()).apply {
        setContent {
            ScopesTheme { block() }
        }
    }
}

inline fun <T> Fragment.findParent(selector: Any.() -> T?): T {
    var currentFragment: Fragment? = this
    var selected: T?
    do {
        val parentFragment = currentFragment?.parentFragment
        selected = parentFragment?.selector()
        if (selected != null) {
            return selected
        }
        currentFragment = parentFragment
    } while (currentFragment != null)
    return activity?.selector()
        ?: activity?.application?.selector()
        ?: error("Couldn't find fitting component in tree ")
}

inline fun <reified T> Fragment.findComponent(): T = findParent<T> {
    (this as? ComponentProvider<*>)?.component as? T
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> Fragment.viewModels(noinline viewModelProvider: () -> T): Lazy<T> {
    return viewModels {
        object : ViewModelProvider.Factory {
            override fun <VM : ViewModel> create(modelClass: Class<VM>): VM =
                viewModelProvider() as VM
        }
    }
}

inline fun <reified T : ViewModel> Fragment.lazyViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = viewModels<T> {
    Factory(this, create)
}

inline fun <T> SavedStateHandle.getOrSet(key: String, block: () -> T): T {
    val value = get<T>(key)
    if (value != null) {
        return value
    }
    val newValue = block()
    set(key, newValue)
    return newValue
}