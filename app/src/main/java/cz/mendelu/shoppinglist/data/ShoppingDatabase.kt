package cz.mendelu.shoppinglist.data

import androidx.room.Database
import androidx.room.RoomDatabase

// аннотация Room, указывающая, какие сущности используются и версия базы данных
@Database(entities = [ShoppingItem::class], version = 1, exportSchema = false)
// абстрактный класс базы данных, наследуется от RoomDatabase
abstract class ShoppingDatabase : RoomDatabase() {
    // абстрактный метод, возвращающий DAO для работы с элементами покупок
    abstract fun shoppingItemDao(): ShoppingItemDao
}