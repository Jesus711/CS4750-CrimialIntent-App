package com.jruelasperez.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import com.jruelasperez.criminalintent.Crime
import java.util.*

@Dao
interface CrimeDao{

    @Query("Select * from Crime")
    fun getCrimes(): List<Crime>

    @Query("SELECT * FROM Crime Where id=(:id)")
    fun getCrime(id: UUID): Crime?
}