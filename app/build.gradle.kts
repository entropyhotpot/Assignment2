plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.assignment2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.assignment2"
        minSdk = 31
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val nav_version = "2.8.0"

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    // Material components
    implementation("com.google.android.material:material:1.12.0")

    // Retrofit/API components
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


    // Hilt dependancies
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    // Test dependancies
    // Local unit test dependencies (run on the JVM)
    testImplementation("io.mockk:mockk:1.13.12") // Core MockK library for local unit tests
    testImplementation("io.mockk:mockk-android:1.13.12") // Android-specific MockK for local unit tests
    testImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking (e.g., static methods)
    androidTestImplementation(libs.androidx.junit) // JUnit for local unit tests

    // Instrumented test dependencies (run on an Android device or emulator) androidTestImplementation("io.mockk:mockk-android:1.13.12") // Android-specific MockK for instrumented tests
    androidTestImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking in instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.3") // AndroidX JUnit for instrumented tests

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}