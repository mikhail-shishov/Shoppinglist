package cz.mendelu.shoppinglist.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

// аннотация Singleton говорит, что будет создан только один экземпляр репозитория
@Singleton
class ShoppingRepository @Inject constructor(
    // внедрение DAO через конструктор
    private val shoppingItemDao: ShoppingItemDao
) {
    // поток всех элементов списка покупок
    val allItems: Flow<List<ShoppingItem>> = shoppingItemDao.getAllItems()

    // метод для вставки элемента
    suspend fun insertItem(item: ShoppingItem) {
        shoppingItemDao.insertItem(item)
    }

    // метод для удаления элемента
    suspend fun deleteItem(item: ShoppingItem) {
        shoppingItemDao.deleteItem(item)
    }
}