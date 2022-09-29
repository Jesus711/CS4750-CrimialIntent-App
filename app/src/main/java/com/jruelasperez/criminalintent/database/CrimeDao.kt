package com.jruelasperez.criminalintent.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jruelasperez.criminalintent.Crime
import java.util.*

@Dao
interface CrimeDao{

    @Query("Select * from Crime")
    fun getCrimes(): LiveData<List<Crime>>

    @Query("SELECT * FROM Crime Where id=(:id)")
    fun getCrime(id: UUID): LiveData<Crime?>

    @Update
    fun updateCrime(crime: Crime)

    @Insert
    fun addCrime(crime: Crime)
}