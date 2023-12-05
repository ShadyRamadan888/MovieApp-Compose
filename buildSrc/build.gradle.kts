import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies{
    implementation("com.android.tools.build:gradle:8.1.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}

