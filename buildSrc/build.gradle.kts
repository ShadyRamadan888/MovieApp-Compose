import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
    `kotlin-dsl`
    `java-library`
}

repositories {
    mavenCentral()
    google()
}

dependencies{
    implementation("com.android.tools.build:gradle:8.1.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    implementation(gradleApi())
    implementation(localGroovy())

    implementation("com.squareup:javapoet:1.13.0")
    implementation("com.google.firebase:firebase-appdistribution-gradle:4.0.0")

}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}

