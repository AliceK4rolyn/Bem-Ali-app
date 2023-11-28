package ifam.edu.br.pdm.listacompras.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.demoapp.data.CommentEntity

@Dao
interface CommentsDAO {
    @Insert
    suspend fun insert(item: CommentEntity): Long

    @Delete
    suspend fun delete(item: CommentEntity): Int

    @Query("select * from CommentEntity")
    suspend fun getAll(): List<CommentEntity>
}