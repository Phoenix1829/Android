package com.android

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.FontResourcesParserCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.white))
            ) {
                Image(

                    painter = painterResource(id = R.drawable.preview),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.3f)


                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.MainColor))
                        .clip(RoundedCornerShape(10.dp))


                ) {
                    Column(

                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 100.dp, start = 20.dp, end = 20.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.description),
                                color = colorResource(id = R.color.white),
                                fontSize = 16.sp,
                                fontFamily = FontFamily.SansSerif


                            )
                        }

                        Row(
                            Modifier
                                .padding(start = 20.dp, top = 25.dp, end = 20.dp)
                                .horizontalScroll(ScrollState(1))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image1),
                                contentDescription = "image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .padding(end = 15.dp)
                                    .size(width = 300.dp, height = 150.dp)
                                    .clip(RoundedCornerShape(15.dp))
                            )


                            Image(
                                painter = painterResource(id = R.drawable.image_dota2),
                                contentDescription = "image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(width = 300.dp, height = 150.dp)
                                    .clip(RoundedCornerShape(10.dp))

                            )
                        }

                        Button(
                            onClick = {},

                            colors = ButtonDefaults.buttonColors(
                                colorResource(id = R.color.colorButtonInstall)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 25.dp, end = 20.dp)




                        ) {
                            Text(
                                text = stringResource(id = R.string.ButtonInstall),
                                color = colorResource(id = R.color.MainColor),
                                fontSize = 25.sp,
                                fontStyle = FontStyle.Normal,


                                )


                        }
                    }
                }
            }
            Box(
                Modifier.padding(top = 200.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(60.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(
                            BorderStroke(2.dp, colorResource(id = R.color.ram)),
                            RoundedCornerShape(10.dp)
                        )

                )
            }
        }
    }
}