package com.example.helpforcleanarchitecture.PhotoFeature.Presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel


@Composable
fun PhotoDetail(photoModel: PhotoModel) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .border(BorderStroke(0.25.dp, Color.LightGray))) {
        Text(text = "Photo id = "+photoModel.id.toString(), modifier = Modifier.padding(8.dp).border(BorderStroke(0.5.dp, Color.LightGray)).fillMaxWidth())
        Text(text = "Photo title = "+photoModel.title.toString(), modifier = Modifier.padding(8.dp).border(BorderStroke(0.5.dp, Color.LightGray)).fillMaxWidth())
        Text(text = "Photo albumId = "+photoModel.albumId.toString(), modifier = Modifier.padding(8.dp).border(BorderStroke(0.25.dp, Color.LightGray)).fillMaxWidth())
        Text(text = "Photo thumbnailUrl = "+photoModel.thumbnailUrl.toString(), modifier = Modifier.padding(8.dp).border(BorderStroke(0.5.dp, Color.LightGray)).fillMaxWidth())
        Text(text = "Photo url = "+photoModel.url.toString(), modifier = Modifier.padding(8.dp).border(BorderStroke(0.5.dp, Color.LightGray)).fillMaxWidth())
    }



}