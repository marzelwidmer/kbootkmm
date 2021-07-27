import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
                // Kotlinx Date/Time
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.1.1")
                // TODO: 27.07.21 Ktor - commonMain
                implementation("io.ktor:ktor-client-core:1.6.1")
                implementation("io.ktor:ktor-client-json:1.6.1")
                implementation("io.ktor:ktor-client-logging:1.6.1")
                implementation("io.ktor:ktor-client-serialization:1.6.1")
            }

        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                // Ktor
                implementation("io.ktor:ktor-client-android:1.6.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val iosMain by getting {
            dependencies {
                // TODO: 27.07.21 Ktor iosMain
                implementation("io.ktor:ktor-client-ios:1.6.1")
            }
        }
        val iosTest by getting {

        }
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(30)
        targetSdkVersion(30)
    }
}
