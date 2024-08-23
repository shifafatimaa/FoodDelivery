package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fooddelivery.Routes.Routes
import com.example.fooddelivery.screens.Home
import com.example.fooddelivery.screens.Invoice
import com.example.fooddelivery.screens.LocationSet
import com.example.fooddelivery.screens.Locationpreview
import com.example.fooddelivery.screens.Login
import com.example.fooddelivery.screens.Screen1
import com.example.fooddelivery.screens.Screen2
import com.example.fooddelivery.screens.Screen3
import com.example.fooddelivery.screens.Signup
import com.example.fooddelivery.ui.theme.FoodDeliveryTheme
import com.example.fooddelivery.screens.RestaurantDetail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodDeliveryTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.screen1) {
                    composable(Routes.screen1) {
                        Screen1(navController)
                    }
                    composable(Routes.screen2) {
                        Screen2(navController)
                    }
                    composable(Routes.screen3) {
                        Screen3(navController)
                    }
                    composable(Routes.login) {
                        Login(navController)
                    }
                    composable(Routes.signup) {
                        Signup(navController)
                    }
                    composable(Routes.locationpage) {
                        LocationSet(navController)
                    }
                    composable(Routes.home){
                        Home(navController)
                    }
                    composable(
                        route = Routes.restaurantDetail,
                        arguments = listOf(navArgument("restaurantName") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val restaurantName = backStackEntry.arguments?.getString("restaurantName")
                        RestaurantDetail(restaurantName,navController)
                    }
                    composable(
                        route = Routes.invoice,
                        arguments = listOf(navArgument("itemName" + "itemPrice") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val itemName = backStackEntry.arguments?.getString("itemName")
                        val itemPrice = backStackEntry.arguments?.getString("itemPrice")

                        Invoice(itemName,itemPrice)
                    }



                }
                //RestaurantDetail("Panda Express")


            }

        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FoodDeliveryTheme {
//        Greeting("Android")
//    }
//}