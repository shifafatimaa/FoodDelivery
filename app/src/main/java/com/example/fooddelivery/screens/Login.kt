package com.example.fooddelivery.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.colorResource
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

@Composable
fun Login(navController: NavController){

        Column(modifier = Modifier.padding(top=65.dp,start=45.dp), verticalArrangement = Arrangement.spacedBy(50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Log in",
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontSize = 35.sp,
                modifier = Modifier.padding(top=50.dp)
            )
            Column() {
                var email_state by rememberSaveable {
                    mutableStateOf("")
                }
                TextField(
                    value = email_state,
                    onValueChange = {
                        email_state = it
                    },
                    label = { Text(
                        text = "Email",
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    )
                         },
                    colors=TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    )
                )
                var password_state by rememberSaveable {
                    mutableStateOf("")
                }
                TextField(
                    value = password_state,
                    onValueChange = {
                        password_state = it
                    },
                    label = { Text(
                        text = "Password",
                        fontSize = 20.sp ,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)))},
                    colors=TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier.padding(top=20.dp)

                )
                Button(
                    onClick = {   },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.transparent),
                    ),
                    modifier = Modifier
                        .padding(start=220.dp)

                ) {
                    Text(text = "Forget?", color = Color.Blue, fontSize = 20.sp)
                }
                Button(
                    onClick = {
                        navController.navigate(Routes.locationpage)
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.orange)
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top=35.dp)

                ){
                    Text(text = "Sign In",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        modifier = Modifier.padding(start = 40.dp,end=40.dp),
                        fontFamily = FontFamily(Font(R.font.poppins_light))

                    )
                }
                Row(modifier = Modifier.padding(top=20.dp),verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(-22.dp)){
                    Text(
                        text="Don't have an account?",
                        fontSize = 17.sp
                    )

                    Button(
                        onClick = { navController.navigate(Routes.signup)  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.transparent),
                        )
                    ) {
                        Text(text = "Sign Up", color = Color.Blue, fontSize = 17.sp)
                    }
                }
            }
        }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview(){

    val mockNavController = rememberNavController()
    Login(mockNavController)

}
