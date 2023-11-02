package com.android

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoPlayer(
    videoUri: Uri
){
    AndroidView(
        modifier = Modifier
            .padding(end = 15.dp)
            .clip(RoundedCornerShape(15.dp))
            .size(width = 300.dp, height = 150.dp),
        factory = {context ->
            VideoView(context).apply{
                setVideoURI(videoUri)

                val mediaController = MediaController(context)
                mediaController.setAnchorView(this)

                setMediaController(mediaController)

                setOnPreparedListener {
                    start()
                }
            }
        })
}