package uz.abbosbek.mvvm_jetpackcompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import uz.abbosbek.mvvm_jetpackcompose.data.local.entity.CurrencyEntity
import uz.abbosbek.mvvm_jetpackcompose.domain.models.Currency

@Dao
interface CurrencyDao {

    @Upsert
    suspend fun upsertAll(currencies:List<CurrencyEntity>)

    @Query("select * from currencyentity")
    suspend fun getAllData():List<CurrencyEntity>
}