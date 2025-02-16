package com.rensystem.a04_androidintermedio.data.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        //val request = chain.request() //peticion orginal que se hacia al servidor
        val request = chain.request()
            .newBuilder()
            .header("Authorization", tokenManager.getToken())
            .build()
        return chain.proceed(request) //peticion nueva que le llega al servidor
    }
}

class TokenManager @Inject constructor() {
    fun getToken(): String = "miToken:)" //Funcion que accede a BDy recupera token
}

