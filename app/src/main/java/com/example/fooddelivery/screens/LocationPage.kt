package com.example.fooddelivery.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.R
import com.example.fooddelivery.Routes.Routes

@Composable
fun LocationSet(navController: NavController){
    Column(verticalArrangement = Arrangement.spacedBy(40.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 90.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.binocular_girl_ill),
            contentDescription = "Restaurant",
            alignment = Alignment.Center,
            modifier = Modifier.size(250.dp)

        )
        Text(text="Hi,nice to meet you!",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier
        )
        Text(text="Set your location to start exploring restaurants around you",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start=17.dp,end=17.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start=17.dp,end=17.dp)){
            Button(
                onClick = {
                    navController.navigate(Routes.home)
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.orange)
                )
            ){
                Text(text = "Use current location",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 40.dp,end=40.dp)
                )
            }
            Button(
                onClick = {   },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.transparent),
                ),
                modifier = Modifier.padding(top=14.dp)

            ) {
                Text(text = "Set your location manually", color = colorResource(id = R.color.orange), fontSize = 20.sp)
            }
            Text(text = "We only access your location while you are using app to improve your experience", color = Color.Black, fontSize = 19.sp, modifier = Modifier.padding(top=100.dp))

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Locationpreview(){
    val mockNavController = rememberNavController()
    LocationSet(mockNavController)
}