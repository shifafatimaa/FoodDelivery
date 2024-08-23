package com.example.fooddelivery.screens


import android.view.ContentInfo
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.R
import com.example.fooddelivery.Routes.Routes

@Composable
fun Common_screen(image: Painter, headingText: String,subText:String,navController: NavController,destination:String){
    Column(verticalArrangement = Arrangement.spacedBy(60.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 90.dp)
    ) {
        Image(
            painter = image,
            contentDescription = "Restaurant",
            alignment = Alignment.Center,
            modifier = Modifier.size(350.dp)

        )
        Text(text=headingText,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            color = colorResource(id = R.color.orange_red),
            modifier = Modifier
        )
        Text(text=subText,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            modifier = Modifier.padding(start=17.dp,end=17.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Button(
                onClick = {
                    navController.navigate(destination)
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.orange)
                )
            ){
                Text(text = "Continue",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    modifier = Modifier.padding(start = 40.dp,end=40.dp)
                )
            }
            Button(
                onClick = {  navController.navigate(destination) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.transparent),
                ),
                modifier = Modifier.padding(top=14.dp)

            ) {
                Text(text = "Skip", color = Color.Gray, fontSize = 20.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Common_screen_preview(){

    val image= painterResource(R.drawable.restaurant_img)
    val headingText="Select a Restaurant"
    val subText="You can choose your favourite restaurant nearby"
    val destination=Routes.screen3
    Common_screen(image,headingText,subText, navController = rememberNavController(), destination )



}