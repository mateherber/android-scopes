package org.scopes.app.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.color.DynamicColors
import org.scopes.app.R
import org.scopes.app.common.di.ComponentProvider
import org.scopes.app.common.di.Factory
import org.scopes.app.common.di.SavedStateHandleHolderViewModel
import org.scopes.app.common.di.scopedComponent
import org.scopes.app.common.graphId
import org.scopes.app.host.di.MainComponent
import org.scopes.app.host.di.MainComponentFactory

class MainActivity : AppCompatActivity(), ComponentProvider {
    private val navController: NavController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_content_main
        ) as NavHostFragment
        navHostFragment.navController
    }

    @Suppress("UNCHECKED_CAST")
    private val mainComponent: MainComponent by scopedComponent {
        ((application as ComponentProvider).component as MainComponentFactory).mainComponent
    }

    override val component: Any
        get() = getNavGraphComponent(navController.graphId) ?: mainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        DynamicColors.applyToActivityIfAvailable(this)
        setContentView(R.layout.activity_main)
    }

    private fun getNavGraphComponent(graphId: Int?) = when (graphId) {
        R.id.transferGraph -> getNavGraphComponent(graphId) { stateHandle ->
            mainComponent.transferComponent.create(stateHandle)
        }
        else -> null
    }

    private fun getNavGraphComponent(graphId: Int, componentFactory: (SavedStateHandle) -> Any): Any {
        val backStackEntry = navController.getBackStackEntry(graphId)
        val stateHandleHolder = ViewModelProvider(
            backStackEntry,
            Factory(backStackEntry) {
                SavedStateHandleHolderViewModel(it)
            })[SavedStateHandleHolderViewModel::class.java]
        return backStackEntry.scopedComponent {
            componentFactory(stateHandleHolder.savedStateHandle)
        }.value
    }
}
