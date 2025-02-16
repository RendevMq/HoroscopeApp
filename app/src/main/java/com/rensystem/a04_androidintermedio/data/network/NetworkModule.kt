package com.rensystem.a04_androidintermedio.data.network

import com.rensystem.a04_androidintermedio.BuildConfig.BASE_URL
import com.rensystem.a04_androidintermedio.data.RepositoryImpl
import com.rensystem.a04_androidintermedio.data.core.interceptor.AuthInterceptor
import com.rensystem.a04_androidintermedio.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //alcance global
class NetworkModule {

    //Necesito incorporar Retrofit en el proyecto. Con esto podremos INYECTAR el objeto Retrofit en cualquier parte del código donde lo necesitemos.
    @Provides
    @Singleton //Para tener una unica instancia y no se cree multiples veces
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }
    /*fun provideOkHttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }*/

    //Necesito una interfaz ejecutable
    /*Dagger, al inyectar HoroscopeApiService, necesita un Retrofit como parámetro. Como Retrofit no tiene un constructor marcado con @Inject (ya que es una librería externa), Dagger busca en los módulos configurados para ver si hay un mEtodo @Provides que ofrezca una instancia de Retrofit. Como ya lo hemos definido en el mEtodo provideRetrofit(), Dagger lo inyecta automáticamente en el parámetro de providesHoroscopeApiService()*/
    @Provides
    fun providesHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository {
        return RepositoryImpl(apiService)
    }

}
















