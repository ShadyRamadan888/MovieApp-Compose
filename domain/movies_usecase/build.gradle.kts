import gradletools.MainGradlePlugin

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
apply<MainGradlePlugin>()
android {
    namespace = "com.movies.movies_usecase"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(project(Modules.dataRepo))
    implementation(project(Modules.dataModel))
    implementation(libs.koin)
}