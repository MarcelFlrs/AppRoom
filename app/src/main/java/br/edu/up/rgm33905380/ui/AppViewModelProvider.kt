package br.edu.up.rgm33905380.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import br.edu.up.rgm33905380.InventoryApplication
import br.edu.up.rgm33905380.ui.home.HomeViewModel
import br.edu.up.rgm33905380.ui.item.ItemDetailsViewModel
import br.edu.up.rgm33905380.ui.item.ItemEditViewModel
import br.edu.up.rgm33905380.ui.item.ItemEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(inventoryApplication().container.itemsRepository)
        }
    }
}

fun CreationExtras.inventoryApplication(): InventoryApplication {
    val application = this[AndroidViewModelFactory.APPLICATION_KEY]
    return application as? InventoryApplication
        ?: throw IllegalStateException("Application must be an instance of InventoryApplication")
}