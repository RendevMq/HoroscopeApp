plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    alias(libs.plugins.daggerhiltandroid)
    alias(libs.plugins.navigationsafeargs)
}

android {
    namespace = "com.rensystem.a04_androidintermedio"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rensystem.a04_androidintermedio"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.rensystem.a04_androidintermedio.CustomTestRunner"
    }

    packaging {
        // Excluir los archivos conflictivos de los JARs que contienen META-INF/gradle/incremental.annotation.processors
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "renatoname", "horoscap")
            buildConfigField("String", "BASE_URL", "\"https://newastro-production.vercel.app/\"")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "renatoname", "[DEBUG] horoscap")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true

    }

//    Si requiere una version especifica de JVM javaToolchains (pe. la 8)
//    kotlin{
//        jvmToolchain(8)
//    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.navigationfragment)
    implementation(libs.navigationui)
    implementation(libs.daggerhiltandroid)
    kapt(libs.daggerhiltcompiler)
    implementation(libs.retrofit)
    implementation(libs.retrofitgson) // Convertidor Gson para Retrofit
    implementation(libs.okhttp)
    implementation(libs.logininterceptor)
    implementation(libs.cameracore)
    implementation(libs.cameracamera2)
    implementation(libs.cameralifecycle)
    implementation(libs.cameraview)
    implementation(libs.cameraextension)

    testImplementation(libs.junit)
    testImplementation(libs.kotlintest.runner)
    testImplementation(libs.mockk)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.espresso.contrib)
    androidTestImplementation(libs.androidx.espresso.intents)
    androidTestImplementation(libs.daggerhilt.android.testing)
    androidTestImplementation(libs.androidx.fragment.testing)
    androidTestImplementation(libs.daggerhilt.android.compiler)
}