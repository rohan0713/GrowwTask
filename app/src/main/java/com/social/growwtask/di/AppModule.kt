package com.social.growwtask.di

import android.content.Context
import androidx.room.Room
import com.social.growwtask.data.local.room.AppDatabase
import com.social.growwtask.data.remote.ApiInterface
import com.social.growwtask.data.remote.RetrofitClient
import com.social.growwtask.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun databaseService(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "myAppDB.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideContext(@ApplicationContext context: Context) :Context {
        return context
    }

//    @Provides
//    @Singleton
//    fun retrofitService() : Retrofit {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
//
//        return Retrofit.Builder().baseUrl(Constants.url).client(client)
//            .addConverterFactory(GsonConverterFactory.create()).build()
//    }
//
//    @Provides
//    @Singleton
//    fun apiService(retrofit: Retrofit) : ApiInterface {
//        return retrofit.create(ApiInterface::class.java)
//    }
}