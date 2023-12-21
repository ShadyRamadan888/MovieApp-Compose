pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WatchApp"
include(":app")
include(":data:model")
include(":domain")
include(":features")
include(":data:service")
include(":data:repo")
include(":domain:movies_usecase")
include(":features:feature_home")
