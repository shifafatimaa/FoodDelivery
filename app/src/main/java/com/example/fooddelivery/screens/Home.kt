package com.example.fooddelivery.screens

import android.annotation.SuppressLint
import android.graphics.drawable.shapes.Shape
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.R
import com.example.fooddelivery.Routes.Routes
import com.example.fooddelivery.model.Restaurant
import com.google.ai.client.generativeai.type.content


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(modifier = Modifier.padding(start=50.dp)) {
                        Text(
                            text = "Delivering to",
                            color = Color.Black,
                            fontSize = 18.sp,
                        )
                        Text(
                            text = "Lahore",
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.orange_red),
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /* TODO: Handle menu click */ },
                        modifier = Modifier
                            .shadow(
                                elevation = 6.dp,
                                shape = CircleShape,
                                clip = false
                            )
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(50.dp)
                    ) {
                        Icon(Icons.Outlined.Person, contentDescription = "person", modifier = Modifier.size(30.dp))
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        IconButton(
                            onClick = { /* TODO: Handle search click */ },
                            modifier = Modifier
                                .shadow(
                                    elevation = 6.dp,
                                    shape = CircleShape,
                                    clip = false
                                )
                                .clip(CircleShape)
                                .background(Color.White)
                                .size(50.dp)

                        ) {
                            Icon(Icons.Outlined.Search, contentDescription = "Search", modifier = Modifier.size(30.dp))
                        }
                        IconButton(
                            onClick = { /* TODO: Handle cart click */ },
                            modifier = Modifier
                                .shadow(
                                    elevation = 6.dp,
                                    shape = CircleShape,
                                    clip = false
                                )
                                .clip(CircleShape)
                                .background(Color.White)
                                .size(50.dp)

                        ) {
                            Icon(Icons.Outlined.ShoppingCart, contentDescription = "ShoppingCart", modifier = Modifier.size(30.dp))
                        }
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
            ) {
                RestaurantOfTheWeek()
                FoodItemRow()
                ItemClicked(R.drawable.pngegg,R.string.farm_frsh_pizza)
                RestaurantNearYouList(restaurantList,navController)
            }
        }
    )
}

@Composable
fun RestaurantOfTheWeek() {
    Box {
        Column(modifier = Modifier.padding(start = 15.dp, top = 15.dp)) {
            Text(
                text = "Let's Eat !!!",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
            )
            Surface(modifier = Modifier.padding(end = 20.dp, top = 15.dp)) {
                Card(
                    onClick = { /*TODO*/ },
                    elevation = CardDefaults.cardElevation(2.dp),
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(2.dp, colorResource(id = R.color.orange)),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.orange)),
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Column(modifier = Modifier.padding(5.dp)) {
                            IconButton(
                                onClick = { /* TODO: Handle favorite click */ },
                                modifier = Modifier.size(40.dp)
                            ) {
                                Icon(
                                    Icons.Filled.FavoriteBorder,
                                    tint = Color.White,
                                    contentDescription = "favorite",
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                            Text(
                                text = "Restaurant of the week",
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                textAlign = TextAlign.Center,
                                color = Color.White,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                            Text(
                                text = "Hengbok Restaurant",
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                modifier = Modifier.padding(start = 10.dp),
                                color = colorResource(id = R.color.red)
                            )
                            IconButton(
                                onClick = { /* TODO: Handle forward click */ },
                                modifier = Modifier
                                    .padding(start = 10.dp, top = 8.dp)
                                    .shadow(1.dp, CircleShape)
                                    .clip(CircleShape)
                                    .size(35.dp)
                                    .background(Color.White)
                            ) {
                                Icon(
                                    Icons.Outlined.ArrowForward,
                                    contentDescription = "forward",
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.seek_png),
            contentDescription = "seek",
            alignment = Alignment.Center,
            modifier = Modifier
                .size(250.dp)
                .padding(top = 35.dp, start = 110.dp)
                .align(Alignment.CenterEnd)
        )
        Text(
            text = "What are you craving for?",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier.padding(top=230.dp,start=15.dp)
        )
    }

}

@Composable
fun FoodItem(@DrawableRes drawable: Int, @StringRes text: Int) {
    Surface(modifier = Modifier.padding(end = 20.dp, top = 25.dp)) {
        var isSelected by rememberSaveable {
            mutableStateOf(false)
        }
        Card(
            onClick = { isSelected = !isSelected },
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isSelected) colorResource(id = R.color.yellow) else Color.White
            ),
            modifier = Modifier
                .shadow(
                    elevation = 6.dp,
                    shape = CircleShape,
                    clip = false
                )
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White)
                .height(98.dp)
                .width(65.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = drawable),
                    contentDescription = "item",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 13.dp)
                )
                Text(
                    stringResource(id = text),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    modifier = Modifier.padding(start = 12.dp),
                )
                IconButton(
                    onClick = { /* TODO: Handle forward click */ },
                    modifier = Modifier
                        .padding(top = 3.dp, start = 14.dp)
                        .shadow(1.dp, CircleShape)
                        .clip(CircleShape)
                        .size(15.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(Color.Black)
                ) {
                    Icon(
                        Icons.Outlined.ArrowForwardIos,
                        contentDescription = "forward",
                        tint = Color.White,
                        modifier = Modifier.size(10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun FoodItemRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(FoodItemData) { item ->
            FoodItem(drawable = item.drawable, text = item.text)
        }
    }
}
private val FoodItemData = listOf(
    R.drawable.pizza to R.string.pizza,
    R.drawable.cheese_burger to R.string.burger,
    R.drawable.ice_cream_sundae to R.string.sweet,
    R.drawable.noodles to R.string.ramen,
    R.drawable.chicken_rice to R.string.biryani,
    R.drawable.soft_drink to R.string.drinks
).map { DrawableStringPair(it.first, it.second) }


private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)



@Composable
fun ItemClicked(@DrawableRes drawable: Int,@StringRes  text: Int) {
    Column(modifier = Modifier.padding(start = 15.dp, top = 15.dp)) {
        Row() {
            Text(
                text = "Recommended",
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier.padding(top = 9.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = "Pizza",
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 10.dp)
            )
        }
        Surface(modifier = Modifier.padding(end = 20.dp, top = 15.dp)) {
            // Outer Card
            Card(
                onClick = {  },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .height(218.dp)
                    .fillMaxWidth()
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(30.dp),
                        clip = false
                    )
                    .clip(RoundedCornerShape(15.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box() {
                    // Inner Card
                    Card(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(2.dp, colorResource(id = R.color.yellow)),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.yellow)),
                        modifier = Modifier
                            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                            .height(130.dp)
                            .fillMaxWidth(),


                        elevation = CardDefaults.cardElevation(0.dp)
                    ) {


                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp, top = 150.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            Text(
                                stringResource(id = text),
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(top = 9.dp)
                            )
                            Text(
                                text = "Dominos",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }
                        Text(
                            text = "$25.45",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            modifier = Modifier.padding(top = 15.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = drawable),
                        contentDescription = "seek",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .height(160.dp)
                            .width(900.dp)
                            .rotate(4f)
                    )
                }

            }
        }
    }
}


@Composable
fun RestaurantsNearYou(restaurant:Restaurant,navController: NavController){


    Surface(modifier = Modifier.padding(end = 20.dp, top = 15.dp)) {

                Card(
                    onClick = { navController.navigate("restaurantDetail/${restaurant.name}")
                    },
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(2.dp),
                    modifier = Modifier
                        .height(258.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.lightGrey))
            ) {
                    Card(
                        onClick = {
                            navController.navigate("restaurantDetail/${restaurant.name}")

                        },
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
                                painter = painterResource(id = R.drawable.restaurant1),
                                contentDescription = "Background",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(15.dp))
                            )
                            // Foreground Content
                            IconButton(
                                onClick = {
                                    restaurant.isFavorite.value = !restaurant.isFavorite.value
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
                                    imageVector = if(restaurant.isFavorite.value)  Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                                   contentDescription = if(restaurant.isFavorite.value) "Remove from favorite" else "Add to Favorite",
                                   tint = if(restaurant.isFavorite.value) colorResource(id = R.color.orange) else Color.Black
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically,
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
                                    text = restaurant.minTime.toString() + "min",
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
                            text = restaurant.name,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            modifier = Modifier.padding(top = 9.dp)
                        )
                        Text(
                            text = restaurant.type,
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            modifier = Modifier.padding(bottom = 3.dp)

                        )
                    }

                    // Right side Row
                    Row( verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .background(colorResource(id = R.color.green)),
                    ) {
                        Text(
                            text = restaurant.rating.toString(),
                            color = Color.White,
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            modifier = Modifier.padding(start=5.dp)

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


val restaurantList = listOf(
    Restaurant("Domino's Pizza", "Pizza", 4.5, 30, mutableStateOf(true)),
    Restaurant("Burger King", "Fast Food", 4.2, 25, mutableStateOf(false)),
    Restaurant("Panda Express", "Chinese", 4.0, 20, mutableStateOf(false)),
    Restaurant("Chipotle", "Mexican", 4.3, 20, mutableStateOf(true)),
    Restaurant("Subway", "Sandwiches", 4.1, 15, mutableStateOf(false)),
    Restaurant("Starbucks", "Coffee", 4.6, 10, mutableStateOf(false))
)



@Composable
fun RestaurantNearYouList(restaurants:List<Restaurant>,navController: NavController){

    Column(modifier = Modifier.padding(start=15.dp,top=15.dp)) {
        Text(
            text ="Restaurant near you",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier.padding(top = 9.dp)
        )
        restaurants.forEach { restaurant ->
            RestaurantsNearYou(
                restaurant = restaurant,
                navController = navController

            )
        }
    }
}



//@Preview
//@Composable
//fun RestaurantNearYouListPreview(){
//    RestaurantNearYouList()
//}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RestaurantsNearYouPreview(){
//    RestaurantsNearYou()
//}


//@Preview(showBackground =true)
//@Composable
//fun ItemClickedPreview() {
//    ItemClicked(R.drawable.pngegg,R.string.farm_frsh_pizza,)
//}



//@Preview(showBackground =true )
//@Composable
//fun FoodItemRoWPreview() {
//    FoodItemRow()
//}

//@Preview(showBackground = true)
//@Composable
//fun FoodItemPreview(){
//    FoodItem(   drawable = R.drawable.pizza,
//        text=R.string.pizza,)
//}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RestaurantOfTheWeekPreview(){
//    RestaurantOfTheWeek()
//
//}


@Preview()
@Composable
fun HomePreview() {
    val mockNavController = rememberNavController()
    Home(mockNavController)
}