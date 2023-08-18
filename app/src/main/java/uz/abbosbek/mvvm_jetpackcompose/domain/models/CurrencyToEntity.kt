package uz.abbosbek.mvvm_jetpackcompose.domain.models

import uz.abbosbek.mvvm_jetpackcompose.data.local.entity.CurrencyEntity


fun Currency.currencyToEntity(): CurrencyEntity {
    return CurrencyEntity(
        CcyNm_UZ = CcyNm_UZ,
        Date = Date,
        Diff = Diff,
        Rate = Rate,
        Ccy = Ccy
    )
}