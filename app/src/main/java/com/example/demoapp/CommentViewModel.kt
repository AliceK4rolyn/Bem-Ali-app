package com.example.demoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.data.CommentEntity
import com.example.demoapp.data.CommentDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentViewModel(private val database: CommentDatabase) : ViewModel() {
    val commentLiveData = MutableLiveData<List<CommentModel>>()

    fun addItem(comment: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val entity = CommentEntity(
                id = 0,
                comment = comment
            )
            database.commentsDAO().insert(entity)
            fetchAll()
        }
    }


    // Esta função buscará todos os registros do banco de dados
    private suspend fun fetchAll() {
        val result = database.commentsDAO().getAll().map {
            it.toModel()
        }

        commentLiveData.postValue(result)
    }
}