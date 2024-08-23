package com.example.fooddelivery.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.R
import com.example.fooddelivery.Routes.Routes


@Composable
fun Screen3(navController: NavController){
    val image= painterResource(R.drawable.scooter_img)
    val headingText="Deliver to your home"
    val subText="Fast delivery to your home with minimal or no charges"
    val destination= Routes.login
    Common_screen(image,headingText,subText,navController,destination)
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen3Preview(){
    val mockNavController = rememberNavController()
    Screen3(mockNavController)
}