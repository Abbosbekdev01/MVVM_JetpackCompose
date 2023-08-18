package uz.abbosbek.mvvm_jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import dagger.hilt.android.AndroidEntryPoint
import uz.abbosbek.mvvm_jetpackcompose.domain.MyCurrencyViewModel
import uz.abbosbek.mvvm_jetpackcompose.presenter.MainScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewmodel: MyCurrencyViewModel by viewModels()

    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewmodel)
        }
    }
}
