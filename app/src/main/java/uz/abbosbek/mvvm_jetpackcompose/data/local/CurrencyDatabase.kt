package uz.abbosbek.mvvm_jetpackcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.abbosbek.mvvm_jetpackcompose.data.local.entity.CurrencyEntity

@Database(
    entities = [CurrencyEntity::class],
    version = 1
)
abstract class CurrencyDatabase : RoomDatabase() {

    abstract val currencyDao: CurrencyDao

}