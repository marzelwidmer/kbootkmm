plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    // TODO: 27.07.21 Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
}

android {
    // TODO: 27.07.21
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0"
    }
    kotlinOptions {
        suppressWarnings = true
        jvmTarget = "1.8"
        freeCompilerArgs = listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true",
            "-Xskip-prerelease-check",
            "-Xskip-metadata-version-check",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
    }
    lint {
        isAbortOnError = false
    }


    compileSdkVersion(30)
    defaultConfig {
        applicationId = "ch.keepcalm.kmm.android"
        minSdkVersion(30)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}