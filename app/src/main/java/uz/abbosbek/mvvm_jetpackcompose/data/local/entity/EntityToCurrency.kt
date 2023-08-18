package uz.abbosbek.mvvm_jetpackcompose.data.local.entity

import uz.abbosbek.mvvm_jetpackcompose.domain.models.Currency

fun CurrencyEntity.CurrencyEntityToCurreny(): Currency {
    return Currency(
        CcyNm_UZ = CcyNm_UZ,
        Date = Date,
        Diff = Diff,
        Rate = Rate,
        Ccy = Ccy
    )
}