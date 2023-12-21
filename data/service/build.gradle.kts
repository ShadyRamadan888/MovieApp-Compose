import gradletools.MainGradlePlugin

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.movies.service"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin)

    implementation(libs.kotlin.serialization)

    implementation(libs.ktor.core)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.android)
    implementation(libs.ktor.auth)
    implementation(project(Modules.dataModel))
}