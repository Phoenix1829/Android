package com.android

import android.net.Uri
import android.os.Bundle
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

val Modernist_Bold = FontFamily(Font(R.font.sk_modernist_bold))
val Montserrat_Bold = FontFamily(Font(R.font.montserrat_bold))

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(ScrollState(0))
                    .background(colorResource(id = R.color.MainColor)),
            ) {
                Header()
                Description()
                ReviewAndRatings()
                ButtonInstall()
            }
        }
    }
}
@Composable
fun ContentVideo(uri: Uri) {

    val videoUri = uri

    Modifier.verticalScroll(ScrollState(1))

    Spacer(modifier = Modifier.height(16.dp))

    VideoPlayer(videoUri = videoUri)
}




@Composable
fun Header() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.preview),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )


        Row(Modifier.padding(start = 20.dp, top = 235.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        BorderStroke(2.dp, colorResource(id = R.color.ram)),
                        RoundedCornerShape(10.dp)
                    )
            )

            Column(
                Modifier
                    .padding(top = 20.dp, start = 20.dp),

                ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = colorResource(id = R.color.white),
                    fontSize = 24.sp,
                    style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold)
                )
                Row{
                    RatingBar(
                        rating = 5.0f,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.CountDownload),
                        color = colorResource(id = R.color.colorCountDownload),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 15.dp, top = 3.dp),
                        style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold)


                    )
                }

            }
        }
    }
    Row(
        Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ){
        Tag(stringResource(id = R.string.Tag1))
        Tag(stringResource(id = R.string.Tag2))
        Tag(stringResource(id = R.string.Tag3))
    }
}

@Composable
fun Tag(
    text: String
) {
    TextButton(
        onClick = {},
        Modifier
            .padding(end = 10.dp),
        colors = ButtonDefaults.buttonColors(
            colorResource(id = R.color.colorTag)
        ),

    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.colorTextTag),
            fontSize = 12.sp,
            style = androidx.compose.ui.text.TextStyle(fontFamily = Montserrat_Bold)

        )
    }

}

@Composable
fun ButtonInstall(){
    TextButton(
        onClick = {},
        Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(64.dp),
            shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            colorResource(id = R.color.colorButtonInstall),
        )


    ) {
        Text(
            text = stringResource(id = R.string.ButtonInstall),
            color = colorResource(id = R.color.MainColor),
            fontSize = 25.sp,
            style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold)
        )
    }
}
@Composable
fun Description() {
    Box(
        modifier = Modifier.padding(top = 25.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.description),
            color = colorResource(id = R.color.white),
            fontSize = 16.sp,
            style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold),
            modifier = Modifier.alpha(0.7f)
        )
    }
    Row(
        Modifier
            .padding(start = 20.dp, top = 25.dp, end = 20.dp)
            .horizontalScroll(ScrollState(1))
    ) {


        ContentVideo(Uri.parse("android.resource://com.android/raw/trailer"))
        ContentImage(painterResource(id = R.drawable.image1))
        ContentImage(painterResource(id = R.drawable.image2))
    }
}

@Composable
fun ContentImage(
    painter: Painter
) {
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(end = 15.dp)
            .size(width = 300.dp, height = 150.dp)
            .clip(RoundedCornerShape(15.dp))
    )
}

@Composable
fun ReviewAndRatings() {
    Text(
        text = stringResource(id = R.string.NameChapterRatings),
        color = colorResource(id = R.color.colorRating),
        fontSize = 22.sp,
        style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold),
        modifier = Modifier
            .padding(start = 20.dp, top = 30.dp)
    )

    Rating(
        stringResource(id = R.string.Rating),
        stringResource(id = R.string.CountReviews),
    )

    Review(
        painterResource(id = R.drawable.reviewer1),
        stringResource(id = R.string.NameReviewerOne),
        stringResource(id = R.string.DateReview),
        stringResource(id = R.string.Review)
    )

    Review(
        painterResource(id = R.drawable.reviewer2),
        stringResource(id = R.string.NameReviewerTwo),
        stringResource(id = R.string.DateReview),
        stringResource(id = R.string.Review)
    )
}
@Composable
fun Rating(
    rating: String,
    countReviews: String
) {
    Column(
        Modifier.padding(start = 20.dp, top = 20.dp)
    ) {
        Row{
            Text(
                text = rating,
                color = colorResource(id = R.color.white),
                fontSize = 50.sp,
                style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold)
            )
            Column(Modifier.padding(start = 30.dp, top = 16.dp)) {
                RatingBar(rating = 4.5f)
                Text(
                    text = countReviews,
                    color = colorResource(id = R.color.colorCountReview),
                    fontSize = 16.sp,
                    style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold)
                )

            }
        }
    }
}
@Composable
fun Review(
    painter: Painter,
    name: String,
    date: String,
    review: String

){
    Column {

        Row(Modifier.padding(start = 20.dp, top = 30.dp)

        ) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Column(
                Modifier.padding(start = 20.dp)
            ) {

                Text(
                    text = name,
                    color = colorResource(id = R.color.white),
                    fontSize = 18.sp,
                    style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold)

                )
                Text(
                    text = date,
                    color = colorResource(id = R.color.white),
                    fontSize = 18.sp,
                    style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold),
                    modifier = Modifier.alpha(0.4f)
                )
            }
        }
        Text(
            text = review,
            color = colorResource(id = R.color.white),
            fontSize = 18.sp,
            style = androidx.compose.ui.text.TextStyle(fontFamily = Modernist_Bold),
            modifier = Modifier.padding(start = 20.dp, top = 15.dp, bottom = 30.dp, end = 20.dp)
        )
        DividerReview()
    }
}

@Composable
fun DividerReview() {
    Column(Modifier.padding(start = 40.dp, end = 40.dp)
    ) {
        Divider(color = colorResource(id = R.color.colorDivider), thickness = 1.dp)
    }
}




@Composable
private fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float,
    spaceBetween: Dp = 3.dp
) {

    val image = ImageBitmap.imageResource(id = R.drawable.empty_star)
    val imageFull = ImageBitmap.imageResource(id = R.drawable.full_star)

    val totalCount = 5

    val height = LocalDensity.current.run { image.height.toDp() }
    val width = LocalDensity.current.run { image.width.toDp() }
    val space = LocalDensity.current.run { spaceBetween.toPx() }
    val totalWidth = width * totalCount + spaceBetween * (totalCount - 1)


    Box(
        modifier
            .width(totalWidth)
            .height(height)
            .drawBehind {
                drawRating(rating, image, imageFull, space)
            })
}

private fun DrawScope.drawRating(
    rating: Float,
    image: ImageBitmap,
    imageFull: ImageBitmap,
    space: Float
) {

    val totalCount = 5

    val imageWidth = image.width.toFloat()
    val imageHeight = size.height

    val reminder = rating - rating.toInt()
    val ratingInt = (rating - reminder).toInt()

    for (i in 0 until totalCount) {

        val start = imageWidth * i + space * i

        drawImage(
            image = image,
            topLeft = Offset(start, 0f)
        )
    }

    drawWithLayer {
        for (i in 0 until totalCount) {
            val start = imageWidth * i + space * i
            // Destination
            drawImage(
                image = imageFull,
                topLeft = Offset(start, 0f)
            )
        }

        val end = imageWidth * totalCount + space * (totalCount - 1)
        val start = rating * imageWidth + ratingInt * space
        val size = end - start

        // Source
        drawRect(
            Color.Transparent,
            topLeft = Offset(start, 0f),
            size = Size(size, height = imageHeight),
            blendMode = BlendMode.SrcIn
        )
    }
}

private fun DrawScope.drawWithLayer(block: DrawScope.() -> Unit) {
    with(drawContext.canvas.nativeCanvas) {
        val checkPoint = saveLayer(null, null)
        block()
        restoreToCount(checkPoint)
    }
}
