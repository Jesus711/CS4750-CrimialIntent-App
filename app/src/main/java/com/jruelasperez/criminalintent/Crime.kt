package com.jruelasperez.criminalintent

import java.util.*
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Crime(@PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false)
