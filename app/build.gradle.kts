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

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}