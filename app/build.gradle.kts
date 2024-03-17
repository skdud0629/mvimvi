plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.mvimvi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvimvi"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.02"))
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    implementation(libs.androidx.ui.tooling.preview.android)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("org.orbit-mvi:orbit-core:<latest-version>")
// or, if on Android:
    implementation("org.orbit-mvi:orbit-viewmodel:4.3.2")
// If using Jetpack Compose include
    implementation("org.orbit-mvi:orbit-compose:4.3.2")

// Tests
    testImplementation("org.orbit-mvi:orbit-test:4.3.2")

    implementation("org.orbit-mvi:orbit-compose:4.3.2")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")
}