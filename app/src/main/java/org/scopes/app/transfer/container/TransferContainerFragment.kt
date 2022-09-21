package org.scopes.app.transfer.container

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.scopes.app.R
import org.scopes.app.common.di.ComponentProvider
import org.scopes.app.common.di.scopedComponent
import org.scopes.app.common.findComponent
import org.scopes.app.transfer.container.di.TransferComponent
import org.scopes.app.transfer.container.di.TransferComponentFactory

class TransferContainerFragment : Fragment(), ComponentProvider<TransferComponent> {
    override val component: TransferComponent by scopedComponent {
        findComponent<TransferComponentFactory>().transferComponent
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_container_transfer, container, false)
}