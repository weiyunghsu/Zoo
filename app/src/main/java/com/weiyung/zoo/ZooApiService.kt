package com.weiyung.zoo

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val HOST_NAME = "data.taipei"
private const val API_VERSION = "v1"
private const val BASE_URL = "https://$HOST_NAME/api/$API_VERSION/dataset/"
private const val HOUSE_URL = "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire"
private const val SPECIES_URL = "a3e2b221-75e0-45c1-8f97-75acbd43d613?scope=resourceAquire"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = when (BuildConfig.LOGGER_VISIABLE) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    )
    .build()

interface ZooApiService {
    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    suspend fun getHouse(): HouseResult

    @GET("a3e2b221-75e0-45c1-8f97-75acbd43d613")
    suspend fun getSpecies(): SpeciesResult
}

object ZooApi {
    val retrofitService: ZooApiService by lazy { retrofit.create(ZooApiService::class.java) }
}
