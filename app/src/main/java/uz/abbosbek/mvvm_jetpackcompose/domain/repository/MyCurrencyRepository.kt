package uz.abbosbek.mvvm_jetpackcompose.domain.repository

import uz.abbosbek.mvvm_jetpackcompose.data.local.CurrencyDao
import uz.abbosbek.mvvm_jetpackcompose.data.local.entity.CurrencyEntity
import uz.abbosbek.mvvm_jetpackcompose.data.remote.ApiService
import uz.abbosbek.mvvm_jetpackcompose.data.remote.models.ValyutaResponse
import uz.abbosbek.mvvm_jetpackcompose.domain.models.Currency
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyCurrencyRepository @Inject constructor(
    val apiService: ApiService,
    val currencyDao: CurrencyDao
) {

    suspend fun getData(): List<ValyutaResponse> = apiService.getAllData()

    suspend fun upsertAll(list: List<CurrencyEntity>) {}
    suspend fun getAllCurrency(): List<CurrencyEntity> = currencyDao.getAllData()
}