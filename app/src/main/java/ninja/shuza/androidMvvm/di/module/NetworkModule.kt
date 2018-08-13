package ninja.shuza.androidMvvm.di.module

import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import ninja.shuza.androidMvvm.BASE_URL
import ninja.shuza.androidMvvm.networkIO.ApiService
import ninja.shuza.androidMvvm.networkIO.deserializer.LoginDeserializer
import ninja.shuza.androidMvvm.networkIO.deserializer.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  14-Aug-2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

@Module
class NetworkModule {

    @Provides
    fun provideClient(): OkHttpClient {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        var interceptorBody = HttpLoggingInterceptor()
        interceptorBody.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(interceptorBody)
                .addInterceptor { chain ->
                    var request = chain.request().newBuilder()
                            .addHeader("Token", "API_AUTHENTICATION_TOKEN")
                            .build()

                    Logger.d("URL   ==/   ${request.url()}")
                    Logger.d(request.headers())
                    chain.proceed(request)
                }
                .build()
    }

    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        val gson = GsonBuilder()
                .registerTypeAdapter(LoginResponse::class.java, LoginDeserializer())
                .create()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    fun provideApiService(): ApiService {
        return provideRetrofit(BASE_URL, provideClient()).create(ApiService::class.java)
    }
}