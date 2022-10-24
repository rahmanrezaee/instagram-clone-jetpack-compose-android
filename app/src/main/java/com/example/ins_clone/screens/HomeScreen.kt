package com.example.ins_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ins_clone.R
import com.example.ins_clone.ui.theme.Ins_cloneTheme

@Composable
fun HomeScreen() {

    Scaffold(


        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                title = {
                    Image(
                        modifier = Modifier
                            .width(140.dp)
                            .padding(0.dp, 10.dp, 0.dp, 0.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = null
                    )
                },
                actions = {
                    Image(
                        modifier = Modifier.width(30.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = R.drawable.like), contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Image(
                        modifier = Modifier.width(30.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = R.drawable.message),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                }

            )
        },
        bottomBar = {
            Row(
                Modifier
                    .background(Color.White)
                    .border(1.dp, Color.Gray)
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.home), contentDescription = null
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.search), contentDescription = null
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.save), contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .border(
                            1.dp, Color.Red,
                            CircleShape
                        ),
                    painter = painterResource(id = R.drawable.profile1), contentDescription = null
                )


            }
        }
    ) {

        LazyColumn() {
            item {
                LazyRow() {
                    items(storyList) { item ->
                        Column(

                            Modifier.padding(10.dp, 9.dp),

                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Image(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .border(
                                        1.dp, Color.Red,
                                        CircleShape
                                    )
                                    .padding(3.dp)
                                    .clip(CircleShape)
                                    .border(
                                        2.dp, Color.White,
                                        CircleShape
                                    ),

                                painter = painterResource(id = item.profile),
                                contentDescription = null
                            )
                            Text(text = item.name, style = TextStyle(color = Color.Black))
                        }
                    }
                }
            }

            items(postList) { item ->
                Column(Modifier.padding(0.dp, 10.dp)) {
                    Row(
                        Modifier
                            .padding(10.dp, 0.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                modifier = Modifier
                                    .size(45.dp)
                                    .padding(3.dp)
                                    .clip(CircleShape)
                                    .border(1.dp, Color.Red),
                                painter = painterResource(id = item.profile),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = item.name,
                                style = TextStyle(fontWeight = FontWeight.Medium)
                            )

                        }

                        Image(
                            modifier = Modifier.width(25.dp),
                            contentScale = ContentScale.FillWidth,
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = null
                        )

                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        modifier = Modifier.height(300.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = item.image), contentDescription = null
                    )

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row() {

                            Image(
                                modifier = Modifier.width(25.dp),
                                contentScale = ContentScale.FillWidth,
                                painter = painterResource(id = R.drawable.like),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(5.dp))

                            Image(
                                modifier = Modifier.width(25.dp),
                                contentScale = ContentScale.FillWidth,
                                painter = painterResource(id = R.drawable.comment),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                modifier = Modifier.width(25.dp),
                                contentScale = ContentScale.FillWidth,
                                painter = painterResource(id = R.drawable.share),
                                contentDescription = null
                            )

                        }

                        Image(
                            modifier = Modifier.width(25.dp),
                            contentScale = ContentScale.FillWidth,
                            painter = painterResource(id = R.drawable.save),
                            contentDescription = null
                        )


                    }



                    Column(Modifier.padding(10.dp, 0.dp)) {
                        Text(
                            "100 Likes", style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Text("In publishing and graphic design, relying on meaningful content .... more")

                    }

                }
            }
        }

    }

}


var storyList = mutableListOf(
    Story("Your Story", R.drawable.profile1),
    Story("Jonu", R.drawable.profile2),
    Story("Ahmad", R.drawable.profile3),
    Story("Akbar", R.drawable.profile4),
    Story("julia", R.drawable.profile5),
    Story("chacku", R.drawable.profile6),
)


var postList = mutableListOf(
    Post("Raj Sing", R.drawable.profile1, image = R.drawable.post1),
    Post("Jonu", R.drawable.profile2, image = R.drawable.post2),
)


data class Story(val name: String, val profile: Int);
data class Post(val name: String, val profile: Int, val image: Int);
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ins_cloneTheme {
        HomeScreen()
    }
}