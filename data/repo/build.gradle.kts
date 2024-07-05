import gradletools.MainGradlePlugin

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply<MainGradlePlugin>()

android {
    namespace = "com.movies.repo"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin)
    implementation(libs.kotlinx.coroutines.core)
    implementation(project(Modules.dataService))
    implementation(project(Modules.dataModel))
    implementation(libs.compose.paging)
}