package cz.mendelu.shoppinglist.di

import android.content.Context
import androidx.room.Room
import cz.mendelu.shoppinglist.data.ShoppingDatabase
import cz.mendelu.shoppinglist.data.ShoppingItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// аннотация Module делает этот объект модулем Dagger Hilt
@Module
// указывает, что зависимости доступны на уровне всего приложения
@InstallIn(SingletonComponent::class)
object AppModule {
    // предоставляет синглтон экземпляр базы данных
    @Provides
    @Singleton
    fun provideShoppingDatabase(@ApplicationContext context: Context): ShoppingDatabase {
        return Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            "shopping_database"
        ).build()
    }

    // предоставляет DAO из экземпляра базы данных
    @Provides
    fun provideShoppingItemDao(database: ShoppingDatabase): ShoppingItemDao {
        return database.shoppingItemDao()
    }
}