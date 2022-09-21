package org.scopes.app.transfer.first.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import org.scopes.app.common.composeView
import org.scopes.app.common.di.scopedComponent
import org.scopes.app.common.findComponent
import org.scopes.app.common.lazyViewModel
import org.scopes.app.transfer.first.di.FirstComponent
import org.scopes.app.transfer.first.di.FirstComponentFactory

class FirstTransferFragment : Fragment() {
    private val component: FirstComponent by scopedComponent {
        findComponent<FirstComponentFactory>().firstComponent
    }

    private val viewModel: FirstTransferViewModel by lazyViewModel { stateHandle ->
        component.viewModel.create(stateHandle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        FirstTransferScreen(viewModel = viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.navigate.filterNotNull().collect {
                    viewModel.clearNavigation()
                    findNavController().navigate(FirstTransferFragmentDirections.actionFirstTransferFragmentToSecondTransferFragment())
                }
            }
        }
    }
}