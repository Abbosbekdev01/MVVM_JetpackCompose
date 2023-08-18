package uz.abbosbek.mvvm_jetpackcompose.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.abbosbek.mvvm_jetpackcompose.domain.MyCurrencyViewModel
import uz.abbosbek.mvvm_jetpackcompose.domain.models.Currency
import uz.abbosbek.mvvm_jetpackcompose.domain.models.currencyToEntity

@Composable
fun MainScreen(
    viewModel: MyCurrencyViewModel,
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    val list by viewModel.getData().collectAsState()
    viewModel.updateLocal(list.map { it -> it.currencyToEntity() })
    Column {
        TopBar()
        Spacer(modifier = Modifier.height(15.dp))
        MainSection(list)
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier
        .background(Color(0xFF5EAD72))
        .padding(vertical = 15.dp)
) {
    Text(
        text = "Currency List",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        color = Color.White
    )
}

@Composable
fun MainSection(
    list: List<Currency>
) {
    LazyColumn() {
        items(list.size) {
            CurrencyItem(list[it])
        }
    }
}

@Composable
fun CurrencyItem(currency: Currency) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(15.dp)
    ) {
        Text(
            text = currency.CcyNm_UZ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
        )
        Spacer(
            modifier = Modifier
                .height(5.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )
        Text(
            text = currency.Rate,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    CurrencyItem(
        currency = Currency(
            "AQSH dollari",
            "18.08.2023",
            "-22.81",
            "12066.19",
            "USD"
        )
    )
}