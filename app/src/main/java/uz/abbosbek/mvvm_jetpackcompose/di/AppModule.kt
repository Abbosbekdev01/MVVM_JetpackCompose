package uz.abbosbek.mvvm_jetpackcompose.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.abbosbek.mvvm_jetpackcompose.data.local.CurrencyDao
import uz.abbosbek.mvvm_jetpackcompose.data.local.CurrencyDatabase
import uz.abbosbek.mvvm_jetpackcompose.data.remote.ApiService
import uz.abbosbek.mvvm_jetpackcompose.data.remote.ApiService.Companion.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providegetApiSerivice(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideDatabase(application: Application): CurrencyDatabase {
        return Room
            .databaseBuilder(
                application,
                CurrencyDatabase::class.java,
                "currency_db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyDao(database: CurrencyDatabase): CurrencyDao {
        return database.currencyDao
    }

}