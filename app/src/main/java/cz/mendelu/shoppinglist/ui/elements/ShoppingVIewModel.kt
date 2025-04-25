package cz.mendelu.shoppinglist.ui.elements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.mendelu.shoppinglist.data.ShoppingItem
import cz.mendelu.shoppinglist.data.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val repository: ShoppingRepository
) : ViewModel() {

    // поток всех товаров из репозитория
    val items: StateFlow<List<ShoppingItem>> = repository.allItems
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // добавление нового товара
    fun addItem(name: String, quantity: Int) {
        if (name.isNotBlank() && quantity > 0) {
            viewModelScope.launch {
                repository.insertItem(ShoppingItem(name = name, quantity = quantity))
            }
        }
    }

    // удаление товара
    fun deleteItem(item: ShoppingItem) {
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }
}