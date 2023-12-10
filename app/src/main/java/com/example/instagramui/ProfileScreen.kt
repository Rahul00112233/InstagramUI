package com.example.instagramui

import android.support.v4.os.IResultReceiver2.Default
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.concurrent.CountDownLatch

@Composable
fun ProfileScreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        TopBar(name = "rahul.maurya.3",
            modifier = Modifier.padding(all = 12.dp))
        Spacer(modifier = Modifier.height(12.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(8.dp))
        ProfileDescripton(
            descHeading = "An Engineering Student!",
            description ="I want to do great in the field of Android Development.",
            link ="https://www.linkedin.com/in/rahul-maurya-846077214",
            followers = listOf("saurabh", "kc"),
            otherCount = 100
        )
        Spacer(modifier = Modifier.height(12.dp))
        ProfileButtons(modifier = Modifier.padding(all = 20.dp))
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(highlight = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.story),
                text = "Youtube"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.story),
                text = "Twitter"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.story),
                text = "Discord"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.story),
                text = "Telegram"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.story),
                text = "Facebook"
            )
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TabViewSection(imageWithTexts = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.icons8_grid_50),
                text = "Posts"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.icons8_reels_50),
                text = "Reels"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.icons8_igtv_50),
                text = "IGTV"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.icons8_admin_settings_male_48),
                text = "Profile"
            )
        )) {
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostSection(posts = listOf(
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat),
                painterResource(id = R.drawable.virat)
            ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier:Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Arrow")

        Text(text = name,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        
        Icon(painter = painterResource(id = R.drawable.icons8_bell_50),
            contentDescription = "Bell Icon",
            modifier = Modifier.size(22.dp)
        )

        Icon(painter = painterResource(id = R.drawable.icons8_three_dots_30),
            contentDescription = "menu Icon",
            modifier = Modifier.size(22.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(image = painterResource(id = R.drawable.rahul),
                modifier = Modifier
                    .weight(3f)

            )
            Spacer(modifier = Modifier.width(32.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier:Modifier = Modifier
){
    Image(painter = image,
        contentDescription = "Profile Image",
        modifier = Modifier
            .size(72.dp)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, shape = CircleShape, color = Color.Black)
            .padding(all = 3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    ){
        ProfileStat(number = "0", text = "Posts")
        ProfileStat(number = "105", text = "Followers")
        ProfileStat(number = "100", text = "Following")
    }
}

@Composable
fun ProfileStat(
    number: String,
    text: String
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = number,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp

            )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}
@Composable
fun ProfileDescripton(
    descHeading: String,
    description: String,
    link: String,
    followers: List<String>,
    otherCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        Text(text = descHeading,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight)
        Text(text = link,
            color = Color.Blue,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight)
        Text(text = buildAnnotatedString {
            val boldStyle = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            append("Followed by ")
            followers.forEachIndexed{ index, name ->
                pushStyle(boldStyle)
                append(name)
                pop()
                if (index < followers.size-1){
                    append(", ")
                }
            }
            if( otherCount > 2){
                append(" and ")
                pushStyle(boldStyle)
                append("$otherCount others")
            }
        },
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
    }
}

@Composable
fun ProfileButtons(
    modifier: Modifier = Modifier
){
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
    }
}
@Composable
fun ActionButton(
    text: String? = null,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.dp,
                Color.Black,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(all = 6.dp)
    ) {
        if(text != null) {
            Text(text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp)
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlight: List<ImageWithText>
){
    LazyRow(modifier = Modifier) {
        items(highlight.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                RoundImage(
                    image = highlight[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlight[it].text,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
@Composable
fun TabViewSection(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color.Gray

TabRow(
    selectedTabIndex = selectedTabIndex,
    Modifier.background(Color.Transparent),
    contentColor = Color.Black
) {
    imageWithTexts.forEachIndexed { index, item ->
        Tab(
            selected = selectedTabIndex == 0,
            selectedContentColor = Color.Black,
            unselectedContentColor = inactiveColor,
            onClick = {
                selectedTabIndex = 0
                onTabSelected(0)
            }
        ) {
            Icon(painter = item.image,
                contentDescription = item.text,
                tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp)
            )
        }
    }
}
}
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .scale(1.01f)
    ) {
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )

            )
        }
    }
}