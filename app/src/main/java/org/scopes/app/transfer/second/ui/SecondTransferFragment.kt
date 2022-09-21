package org.scopes.app.transfer.second.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.scopes.app.common.composeView
import org.scopes.app.common.di.scopedComponent
import org.scopes.app.common.findComponent
import org.scopes.app.common.viewModels
import org.scopes.app.transfer.second.di.SecondComponent
import org.scopes.app.transfer.second.di.SecondComponentFactory

class SecondTransferFragment : Fragment() {
    private val component: SecondComponent by scopedComponent {
        findComponent<SecondComponentFactory>().secondComponent
    }

    private val viewModel: SecondTransferViewModel by viewModels { component.viewModel }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        SecondTransferScreen(viewModel = viewModel)
    }
}