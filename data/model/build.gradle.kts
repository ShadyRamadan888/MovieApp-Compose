@file:Suppress("DSL_SCOPE_VIOLATION")
import gradletools.MainGradlePlugin
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}
apply<MainGradlePlugin>()

android {
    namespace = "com.movies.model"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlin.serialization)

}