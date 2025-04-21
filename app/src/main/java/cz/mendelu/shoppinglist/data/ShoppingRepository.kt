package cz.mendelu.shoppinglist.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShoppingRepository @Inject constructor(
    private val shoppingItemDao: ShoppingItemDao
) {
    val allItems: Flow<List<ShoppingItem>> = shoppingItemDao.getAllItems()

    suspend fun insertItem(item: ShoppingItem) {
        shoppingItemDao.insertItem(item)
    }

    suspend fun deleteItem(item: ShoppingItem) {
        shoppingItemDao.deleteItem(item)
    }
}