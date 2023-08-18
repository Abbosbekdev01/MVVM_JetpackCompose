package uz.abbosbek.mvvm_jetpackcompose.data.remote.models

import uz.abbosbek.mvvm_jetpackcompose.domain.models.Currency

fun ValyutaResponse.toCurrency(): Currency {
    return Currency(
        CcyNm_UZ = CcyNm_UZ,
        Date = Date,
        Diff = Diff,
        Rate = Rate,
        Ccy = Ccy
    )
}