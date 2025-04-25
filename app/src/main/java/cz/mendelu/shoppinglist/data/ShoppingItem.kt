package cz.mendelu.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// аннотация Entity указывает, что класс является таблицей базы данных
@Entity(tableName = "shopping_items")
// дата-класс, представляющий элемент списка покупок
data class ShoppingItem(
    // первичный ключ, генерируется автоматически
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    // название товара
    val name: String,
    // количество товара
    val quantity: Int
)