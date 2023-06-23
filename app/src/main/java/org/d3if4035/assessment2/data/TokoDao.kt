package org.d3if4035.assessment2.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TokoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: TokoEntity)
    
    @Query("SELECT * FROM forassessment_table ORDER BY id")
    fun getDataToko(): LiveData<List<TokoEntity>>

    @Delete
    suspend fun delete(data: TokoEntity)
}