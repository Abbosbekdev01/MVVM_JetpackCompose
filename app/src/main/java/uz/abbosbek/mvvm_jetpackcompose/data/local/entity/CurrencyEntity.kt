package uz.abbosbek.mvvm_jetpackcompose.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    val CcyNm_UZ: String,
    val Date: String,
    val Diff: String,
    val Rate: String,
    val Ccy: String
)