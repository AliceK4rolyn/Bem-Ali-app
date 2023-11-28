package com.example.demoapp

import android.net.Uri
import com.example.demoapp.data.CommentEntity

data class CommentModel(
    val id: Long,
    val comment: String,
) {
    fun toEntity(): CommentEntity {
        return CommentEntity(
            id = this.id,
            comment = this.comment,
        )
    }
}