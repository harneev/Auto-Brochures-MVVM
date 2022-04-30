package com.auto.brochure

import com.auto.brochure.repository.CarInfoRepository
import com.auto.brochure.repository.CarInfoRepositoryImpl
import com.auto.brochure.repository.datasource.RetrofitApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    const val BASE_URL = "https://parallelum.com.br/fipe/api/v1/"

    @Provides
    fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor;
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    fun providerRetrofit(okHttpClient: OkHttpClient): RetrofitApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RetrofitApiService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class MVPModule {

    @Binds
    abstract fun bindCarInfoRepository(repository: CarInfoRepositoryImpl): CarInfoRepository
}