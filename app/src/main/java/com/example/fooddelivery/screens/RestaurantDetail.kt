package com.example.fooddelivery.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.Routes.Routes
import com.example.fooddelivery.model.FoodItem
import com.example.fooddelivery.model.Restaurant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetail(restaurantName: String?,navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                },
                navigationIcon = {
                    IconButton(
                        onClick = { /* TODO: Handle menu click */ },

                    ) {
                        Icon(Icons.Outlined.ArrowBackIosNew, contentDescription = "person", modifier = Modifier.size(30.dp))
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {

                        IconButton(
                            onClick = { /* TODO: Handle cart click */ },
                        ) {
                            Icon(Icons.Outlined.ShoppingCart, contentDescription = "ShoppingCart", modifier = Modifier.size(30.dp))
                        }
                        IconButton(
                            onClick = { /* TODO: Handle search click */ },
                        ) {
                            Icon(Icons.Outlined.BookmarkBorder,
                                contentDescription = "Bookmark",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                        IconButton(
                            onClick = { /* TODO: Handle search click */ },
                        ) {
                            Icon(
                                painterResource(id = R.drawable.share),
                                contentDescription = "Arrow",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(30.dp)


                            )
                        }
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(paddingValues)
                .padding(start = 15.dp, end = 15.dp)
                .verticalScroll(rememberScrollState())
            ) {
                RestaurantTitle()
                TimeOfferReviews()
                SearchBar()
                Recommended(restaurantName, navController )

            }
        }
    )

}


@Composable
fun RestaurantTitle(){
    var isExpanded by remember { mutableStateOf(false) }
    Column {


        Text(
            text = "Divine",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier.padding(top = 6.dp)
        )
        Text(
            text = "Chines,Asian,FastFood",
            color = Color.Black,
            fontSize = 10.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
        )
        Text(
            text = if(isExpanded) "More text show hser we need more food and delicious food like pizzza butgr djkfdckckcxcxdsdsm dfkddfmdncxkjdsfd" else "more",
            color = if(isExpanded) Color.Black else Color.Blue,
            fontSize = 10.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier
                .clickable { 
                    isExpanded = !isExpanded
                }
        )
    }
}


@Composable
fun TimeOfferReviews(modifier: Modifier = Modifier) {
    Row( horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier
        .padding(top=15.dp)

      ) {
        Card(
            colors = CardDefaults.cardColors(colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(1.dp),
            modifier = modifier
                .padding(start = 10.dp, end = 20.dp)
                .width(96.dp)
                .height(45.dp)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

            ) {
                Text(

                    text = "Time",
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    modifier = Modifier.background(Color.Blue)


                )
                Text(
                    text = "40 mins",
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    modifier = Modifier.background(Color.Yellow)
                )
            }

        }
        Card(
            colors = CardDefaults.cardColors(colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(1.dp),
            modifier = modifier
                .padding(start = 10.dp, end = 20.dp)
                .width(96.dp)
                .height(45.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp),
                horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                verticalArrangement = Arrangement.Center // Center vertically
            ) {
                Row() {
                    Text(
                        text = "Offers",
                        color = Color.Black,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                    Icon(
                        imageVector = Icons.Outlined.ArrowForwardIos,
                        contentDescription = "Dropdown",
                        tint = Color.Gray,
                        modifier = Modifier
                            .rotate(90f)
                            .size(13.dp)
                            .padding(start = 5.dp)

                    )
                }

                Text(
                    text = "View all(5)",
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }

        }
        Card(
            colors = CardDefaults.cardColors(colorResource(id = R.color.white)),
            elevation = CardDefaults.cardElevation(1.dp),
            modifier = modifier
                .padding(start = 10.dp, end = 20.dp)
                .width(96.dp)
                .height(45.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                verticalArrangement = Arrangement.Center // Center vertically
            ) {
                Text(
                    text = "Reviews",
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .background(colorResource(id = R.color.green))
                ) {
                    Text(
                        text = "4.1",
                        color = Color.White,
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        modifier = Modifier.padding(start = 5.dp)

                    )
                    Icon(
                        modifier = Modifier
                            .size(15.dp)
                            .align(Alignment.CenterVertically)
                            .padding(start = 3.dp, end = 3.dp),
                        imageVector = Icons.Filled.StarRate,
                        contentDescription = "star",
                        tint = Color.White
                    )
                }

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SearchBar(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
Column(modifier = Modifier.padding( top = 25.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White, shape = RoundedCornerShape(28.dp))
               ,
            placeholder = {
                Text(
                    text = "Search",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )

            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon",
                    tint = Color.Gray
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(28.dp)
        )
    Text(
        text = "Recommended",
        color = Color.Black,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        modifier=Modifier.padding(top=15.dp)
    )
}
}

@Composable
fun Recommended( name:String?,navController: NavController){

    val itemsForSelectedRestaurant = foodItems[name] ?: emptyList()

    itemsForSelectedRestaurant.forEach { foodItem ->
        // Display each food item

        Surface(modifier = Modifier.padding(end = 20.dp, top = 15.dp)) {

            Card(
                onClick = { },
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .height(290.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.lightGrey))
            ) {
                Card(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(2.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Box {
                        // Background Image
                        Image(
                            painter = painterResource(id =foodItem.imageResId),
                            contentDescription = "Background",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(15.dp))
                        )
                        // Foreground Content
                        IconButton(
                            onClick = {
                                foodItem.isFavorite.value = !foodItem.isFavorite.value
                            },
                            modifier = Modifier
                                .padding(end = 10.dp, top = 10.dp)
                                .shadow(1.dp, CircleShape)
                                .align(Alignment.TopEnd)
                                .clip(CircleShape)
                                .size(30.dp)
                                .background(Color.White)

                        ) {
                            Icon(
                                imageVector = if (foodItem.isFavorite.value) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                                contentDescription = if (foodItem.isFavorite.value) "Remove from favorite" else "Add to Favorite",
                                tint = if (foodItem.isFavorite.value) colorResource(id = R.color.orange) else Color.Black
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(end = 10.dp, bottom = 5.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .background(Color.White)
                                .align(Alignment.BottomEnd),

                            ) {
                            Text(
                                text = foodItem.minTime.toString() + "min",
                                color = Color.Black,
                                fontSize = 8.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 3.dp, end = 3.dp),

                                )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween, // Space between the Column and Row
                    verticalAlignment = Alignment.CenterVertically // Align vertically at the center
                ) {
                    // Left side Column
                    Column {
                        Text(
                            text = foodItem.name,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            modifier = Modifier.padding(top = 9.dp)
                        )
                        Text(
                            text = "Rs. ${foodItem.price}",
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            modifier = Modifier.padding(bottom = 3.dp)

                        )
                       OutlinedButton(
                           onClick = { /*TODO*/ },
                           border = BorderStroke(1.dp, colorResource(id = R.color.stroke_color)),
                           colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.bestsellerbackgraound)),
                           modifier = Modifier

                               .height(50.dp)
                               .width(80.dp)
                               .padding(bottom = 10.dp)

                           ,
                           contentPadding = PaddingValues(0.dp)

                       ){
                            Text(
                                text = "Bestseller",
                                color = colorResource(id = R.color.best_seller_red),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular))
                            )
                        }
                    }
                    Column(horizontalAlignment = Alignment.End){
                    // Right side Row

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .background(colorResource(id = R.color.green))
                              

                        ) {
                            Text(
                                text = foodItem.rating.toString(),
                                color = Color.White,
                                fontSize = 8.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(start = 5.dp)

                            )
                            Icon(
                                modifier = Modifier
                                    .size(15.dp)
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 3.dp, end = 3.dp),
                                imageVector = Icons.Filled.StarRate,
                                contentDescription = "star",
                                tint = Color.White
                            )
                        }
                        OutlinedButton(
                            onClick = {                    navController.navigate("restaurantDetail/${foodItem.name}/${foodItem.price}")
                            },
                            modifier = Modifier
                                .height(40.dp)
                                .width(100.dp)
                                .padding(top = 6.dp),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, Color.Red),
                            contentPadding = PaddingValues(8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "ADD",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    modifier=Modifier
                                        .padding(start=17.dp)
                                )

                                // Spacer to push the icon to the right
                                Spacer(modifier = Modifier.weight(1f))

                                // Icon to display at the end of the button
                                Icon(
                                    imageVector = Icons.Outlined.AddCircleOutline,
                                    contentDescription = "Add icon",
                                    tint = Color.Red,
                                    modifier = Modifier
                                        .size(47.dp)
                                        .padding(start = 10.dp, bottom = 10.dp)
                                )
                            }
                        }

                    }
                }
            }
        }

    }

}

val foodItems = mapOf(
    "Domino's Pizza" to listOf(
        FoodItem("Margherita Pizza", "Pizza", 999.00, mutableStateOf(true), 4.5, 15, R.drawable.delicious_italian_pizza_wooden_table),
        FoodItem("Pepperoni Pizza", "Pizza", 1199.00, mutableStateOf(true), 4.7, 20, R.drawable.pngegg)
    ),
    "Burger King" to listOf(
        FoodItem("Whopper", "Burger", 899.00, mutableStateOf(false), 4.3, 10, R.drawable.kofty),
        FoodItem("Chicken Fries", "Snack", 399.00, mutableStateOf(true), 4.0, 5, R.drawable.restaurant2)
    ),
    "Panda Express" to listOf(
        FoodItem("Orange Chicken", "Chinese", 1099.00, mutableStateOf(true), 4.4, 15, R.drawable.hicken_pumpkin_soup_board_spoon_oil_lemon),
        FoodItem("Chowmin", "Chinese", 1199.00, mutableStateOf(false), 4.2, 20, R.drawable.noodles2),
        FoodItem("Kofty", "Pakistani", 2000.00, mutableStateOf(false), 4.7, 20, R.drawable.kofty)

),
    "Chipotle" to listOf(
        FoodItem("Chicken Burrito", "Mexican", 1299.00, mutableStateOf(true), 4.6, 20, R.drawable.hicken_pumpkin_soup_board_spoon_oil_lemon),
        FoodItem("Beef Taco", "Mexican", 399.00, mutableStateOf(true), 4.1, 10, R.drawable.hicken_pumpkin_soup_board_spoon_oil_lemon),
    ),
    "Subway" to listOf(
        FoodItem("Turkey Sandwich", "Sandwich", 799.00, mutableStateOf(true), 4.2, 10, R.drawable.kofty),
        FoodItem("Chicken Teriyaki", "Sandwich", 849.00, mutableStateOf(true), 4.4, 12, R.drawable.noodles2)
    ),
    "Starbucks" to listOf(
        FoodItem("Caffè Latte", "Coffee", 499.00, mutableStateOf(true), 4.6, 5, R.drawable.delicious_italian_pizza_wooden_table),
        FoodItem("Caramel Macchiato", "Coffee", 549.00, mutableStateOf(true), 4.3, 5, R.drawable.restaurant1)
    )
)


//@SuppressLint("UnrememberedMutableState")
//@Preview(showSystemUi = true)
//@Composable
//fun RecommendedPreview(){
//    Recommended("Panda Express")
//}
//




//
//@Preview(showSystemUi = true)
//@Composable
//fun SearchBarPreview(){
//SearchBar()
//}





//@Preview(showSystemUi = true)
//@Composable
//fun Time_offer_reviewsPreview(){
//    TimeOfferReviews()
//}
//@Preview()
//@Composable
//fun RestaurantTitlePreview(){
//    RestaurantTitle()
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun RestaurantDetailPreview(){
//    RestaurantDetail("Panda Express")
//}