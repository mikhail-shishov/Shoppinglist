package cz.mendelu.shoppinglist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// аннотация Dao указывает, что интерфейс используется для доступа к данным
@Dao
interface ShoppingItemDao {
    // запрос, получающий все элементы из таблицы
    @Query("SELECT * FROM shopping_items")
    fun getAllItems(): Flow<List<ShoppingItem>>

    // вставка нового элемента с заменой при конфликте
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ShoppingItem)

    // удаление элемента из таблицы
    @Delete
    suspend fun deleteItem(item: ShoppingItem)
}