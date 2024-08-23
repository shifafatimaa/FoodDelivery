package com.example.fooddelivery.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.R
import com.example.fooddelivery.Routes.Routes

@Composable
fun Screen2(navController:NavController){
    val image= painterResource(R.drawable.cookie_img)
    val headingText="Order food you like"
    val subText="You can order your favourite food anytime"
    val destination=Routes.screen3
    Common_screen(image,headingText,subText,navController,destination)
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen2Preview(){
    val mockNavController = rememberNavController()
    Screen2(mockNavController)
}