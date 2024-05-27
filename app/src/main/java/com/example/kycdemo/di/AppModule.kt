package com.example.kycdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideBaseUrl() = ""

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (true) {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(providesOkhttpInterceptor())
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS).setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            )

            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .build()
    } else {

        OkHttpClient
            .Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(providesOkhttpInterceptor())
            /* .addNetworkInterceptor(
                 HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS).setLevel(
                     HttpLoggingInterceptor.Level.BODY
                 )
             )*/

            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .build()
    }

    /* @Singleton
     @Provides
     fun provideOkHttpClient(): OkHttpClient {
         val builder = OkHttpClient.Builder()
             .addInterceptor(providesOkhttpInterceptor())
             .addInterceptor(NetworkConnectionInterceptor(App.getContext()))
             .connectTimeout(2, TimeUnit.MINUTES)
             .readTimeout(5, TimeUnit.MINUTES)
             .writeTimeout(5, TimeUnit.MINUTES)

         if (BuildConfig.DEBUG) {
             val loggingInterceptor = HttpLoggingInterceptor()
             loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
             loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
             builder.addInterceptor(loggingInterceptor)
         }

         return builder.build()
     }*/

    @Provides
    fun providesOkhttpInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                //  .addHeader("X-CMC_PRO_API_KEY", "7d00fe84-d1ea-47da-b2f6-53287366a15c")
                .addHeader("Accept", "application/json")

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }


}