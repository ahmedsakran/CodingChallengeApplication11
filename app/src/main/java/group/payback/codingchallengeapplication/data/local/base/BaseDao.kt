package group.payback.codingchallengeapplication.data.local.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(item: List<T>): List<Long>

    @Update
    suspend fun update(item: T)

    @Delete
    suspend fun delete(item: T)
}