package org.scopes.app.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.color.DynamicColors
import org.scopes.app.R
import org.scopes.app.application.di.ApplicationComponent
import org.scopes.app.common.di.ComponentProvider
import org.scopes.app.common.di.scopedComponent
import org.scopes.app.host.di.MainComponent
import org.scopes.app.host.di.MainComponentFactory

class MainActivity : AppCompatActivity(), ComponentProvider<MainComponent> {
    @Suppress("UNCHECKED_CAST")
    override val component: MainComponent by scopedComponent {
        ((application as ComponentProvider<ApplicationComponent>).component as MainComponentFactory).mainComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        DynamicColors.applyToActivityIfAvailable(this)
        setContentView(R.layout.activity_main)
    }
}
