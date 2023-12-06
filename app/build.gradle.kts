plugins {
    // Application
    id("com.android.application")

    // Kotlin Android
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.marsel"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.marsel"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // Core
    implementation("androidx.core:core-ktx:1.9.0")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    // MaterialDesign
    implementation("com.google.android.material:material:1.10.0")

    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // JUnit
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // EspressoCore
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Koin
    implementation("io.insert-koin:koin-android:3.4.2")

    // Domain
    implementation(project(":domain"))

    // Data
    implementation(project(":data"))

    // Presentation
    implementation(project(":presentation"))

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Gson Converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // LoggingInterceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
}