package org.scopes.app.common.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavedStateHandleHolderViewModel(val savedStateHandle: SavedStateHandle) : ViewModel()