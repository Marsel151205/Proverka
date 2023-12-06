package com.marsel.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.marse.domain.repositories.BookingRepository
import com.marse.domain.repositories.HotelRepository
import com.marse.domain.repositories.NumberRepository
import com.marse.domain.usecases.BookingUseCase
import com.marse.domain.usecases.HotelUseCase
import com.marse.domain.usecases.NumberUseCase
import com.marsel.data.repositories.BookingRepositoryImpl
import com.marsel.data.repositories.HotelRepositoryImpl
import com.marsel.data.repositories.NumberRepositoryImpl
import com.marsel.data.services.BookingApiService
import com.marsel.data.services.HotelApiService
import com.marsel.data.services.NumberApiService
import com.marsel.presentation.ui.fragments.booking.BookingViewModel
import com.marsel.presentation.ui.fragments.hotel.HotelViewModel
import com.marsel.presentation.ui.fragments.number.NumberViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.addInterceptor(interceptor).build()
    }

    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    single { provideGson() }
    single { provideLoggingInterceptor() }
    single { provideHttpClient(get()) }
    single {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }
}

val repositoryModule = module {
    single<HotelRepository> {
        HotelRepositoryImpl(get())
    }
    single<BookingRepository> {
        BookingRepositoryImpl(get())
    }
    single<NumberRepository> {
        NumberRepositoryImpl(get())
    }
}

val useCaseModule = module {
    single {
        HotelUseCase(get())
    }
    single {
        BookingUseCase(get())
    }
    single {
        NumberUseCase(get())
    }
}

val viewModelModule = module {
    viewModel { HotelViewModel(get()) }
    viewModel { BookingViewModel(get()) }
    viewModel { NumberViewModel(get()) }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): HotelApiService =
        retrofit.create(HotelApiService::class.java)

    fun provideBookingApi(retrofit: Retrofit): BookingApiService =
        retrofit.create(BookingApiService::class.java)

    fun provideNumberApi(retrofit: Retrofit): NumberApiService =
        retrofit.create(NumberApiService::class.java)

    single { provideUseApi(get()) }
    single { provideBookingApi(get()) }
    single { provideNumberApi(get()) }
}

