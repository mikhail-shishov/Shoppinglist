package cz.mendelu.shoppinglist.ui.elements

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.mendelu.shoppinglist.ui.elements.AddItemScreen
import cz.mendelu.shoppinglist.ui.elements.HomeScreen
import cz.mendelu.shoppinglist.ui.elements.ItemListScreen

@Composable
fun ShoppingListApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToItemList = { navController.navigate("itemList") }
            )
        }
        composable("itemList") {
            ItemListScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToAddItem = { navController.navigate("addItem") }
            )
        }
        composable("addItem") {
            AddItemScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}