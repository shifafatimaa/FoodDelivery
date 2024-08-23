package com.example.fooddelivery.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
fun Signup(navController: NavController){

    Column(modifier = Modifier.padding(top=65.dp,start=45.dp), verticalArrangement = Arrangement.spacedBy(50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Create new Account",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 35.sp,
            color = colorResource(id = R.color.orange_red),
            modifier = Modifier.padding(top=50.dp)
        )
        Column() {
            var nameState by rememberSaveable {
                mutableStateOf("")
            }
            TextField(
                value = nameState,
                onValueChange = {
                    nameState = it
                },
                label = {
                    Row(
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Person Icon",
                            tint = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp) 
                        )
                        Text(
                            text = "Your Name",
                            fontSize = 20.sp,
                            color = Color.Gray
                        )
                    }
                },
                colors=TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier.padding(top=20.dp)

            )
            var phoneState by rememberSaveable {
                mutableStateOf("")
            }
            TextField(
                value = phoneState,
                onValueChange = {
                    phoneState = it
                },
                label = {
                    Row(){
                        Icon(
                            imageVector = Icons.Filled.Call,
                            contentDescription = "Phone",
                            tint=Color.Gray,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(text = "Phone Number", fontSize = 20.sp , color = Color.Gray)}
                        },
                colors=TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier.padding(top=10.dp)

            )
            var emailState by rememberSaveable {
                mutableStateOf("")
            }
            TextField(
                value = emailState,
                onValueChange = {
                    emailState = it
                },
                label = {
                    Row(
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Person Icon",
                            tint = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(text = "Email", fontSize = 20.sp, color = Color.Gray)
                    }
                },
                colors=TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier.padding(top=10.dp)

            )
            var passwordState by rememberSaveable {
                mutableStateOf("")
            }
            TextField(
                value = passwordState,
                onValueChange = {
                    passwordState = it
                },
                label = {
                    Row(
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Person Icon",
                            tint = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(text = "Password", fontSize = 20.sp, color = Color.Gray)
                    }
                },
                colors=TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier.padding(top=10.dp)

            )
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
                    .padding(top = 35.dp)

            ){
                Text(text = "Sign Up",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 40.dp,end=40.dp),
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                    )
            }
            Row(modifier = Modifier.padding(top=20.dp),verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(-22.dp)){
                Text(
                    text="Already have an account?",
                    fontSize = 17.sp
                )

                Button(
                    onClick = { navController.navigate(Routes.login)  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.transparent),
                    )


                ) {
                    Text(text = "Log In", color = Color.Blue, fontSize = 17.sp)
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupPreview(){


    val mockNavController = rememberNavController()
    Signup(mockNavController)

}
