package com.rensystem.a04_androidintermedio

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

//runner pesonlizado
//para lanzar los test que pase por daggerhilt
//se reemplaza en el gradle el que decia:  testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
class CustomTestRunner:AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}