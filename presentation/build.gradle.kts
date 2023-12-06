plugins {
    // Android Library
    id("com.android.library")

    // Kotlin Android
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.marsel.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Core
    implementation("androidx.core:core-ktx:1.9.0")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    // MaterialDesign
    implementation("com.google.android.material:material:1.4.0")

    // JUnit
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // EspressoCore
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Navigation Component
    val nav_version = "2.7.5"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // ViewPager
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Dots Indicator
    implementation("com.tbuonomo:dotsindicator:5.0")

    // Domain
    implementation(project(":domain"))

    // Koin
    implementation("io.insert-koin:koin-android:3.4.2")
    implementation("io.insert-koin:koin-core:3.4.2")

    // MaskedEditText
    implementation("com.github.santalu:maskara:1.0.0")
}