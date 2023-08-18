package uz.abbosbek.mvvm_jetpackcompose.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.abbosbek.mvvm_jetpackcompose.data.local.entity.CurrencyEntity
import uz.abbosbek.mvvm_jetpackcompose.data.local.entity.CurrencyEntityToCurreny
import uz.abbosbek.mvvm_jetpackcompose.data.remote.models.toCurrency
import uz.abbosbek.mvvm_jetpackcompose.domain.models.Currency
import uz.abbosbek.mvvm_jetpackcompose.domain.models.currencyToEntity
import uz.abbosbek.mvvm_jetpackcompose.domain.repository.MyCurrencyRepository
import javax.inject.Inject

@HiltViewModel
class MyCurrencyViewModel @Inject constructor(var repository: MyCurrencyRepository) : ViewModel() {

    val stateFlow = MutableStateFlow<List<Currency>>(emptyList())

    fun getData(): MutableStateFlow<List<Currency>> {
        viewModelScope.launch {
            stateFlow.value = repository.getData().map { it -> it.toCurrency() }
        }
        return stateFlow
    }

    fun updateLocal(list: List<CurrencyEntity>) {
        viewModelScope.launch {
            repository.currencyDao.upsertAll(list)
        }
    }

    fun getLocal(): MutableStateFlow<List<Currency>> {
        viewModelScope.launch {
            stateFlow.value = repository.getAllCurrency().map { it -> it.CurrencyEntityToCurreny() }
        }
        return stateFlow
    }
}