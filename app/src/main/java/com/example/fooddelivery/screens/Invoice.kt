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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
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
import androidx.compose.ui.graphics.vector.ImageVector
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
fun Invoice(itemName :String?,itemPrice:String?){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                },
                navigationIcon = {
                    IconButton(
                        onClick = { /* TODO: Handle menu click */ },

                        ) {
                        Icon(Icons.Outlined.ArrowBackIosNew, contentDescription = "BackArrow", modifier = Modifier.size(30.dp))
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
                IconAndDeliveryText( icon = Icons.Filled.LocationOn, text = "Delivery at Leonard")
                IconAndDeliveryText( icon = Icons.Outlined.AccessTime, text = "Delivery in 40 mins")
                ItemRow()
            }
        }
    )
}

@Composable
fun IconAndDeliveryText(icon: ImageVector, text: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top=10.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = colorResource(id = R.color.green),
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular))
        )
    }

}

@Composable
fun ItemRow(){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
    Column(modifier = Modifier.weight(1f/2)) {
        Text(
            text = "Chiken Noodles",
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular))
        )
        Text(
            text = "Rs.350",
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular))
        )
    }
        Column() {
        OutlinedButton(
            onClick = {
            },
            modifier = Modifier
                .height(40.dp)
                .width(100.dp)
                .padding(top=6.dp),
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
                        .padding(start=10.dp,bottom=10.dp)
                )
            }
        }
    }
    }


}


@Preview
@Composable
fun InvoicePreview(){
    Invoice("noodles","35")
}