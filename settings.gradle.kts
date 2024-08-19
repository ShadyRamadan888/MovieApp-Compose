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
include(":domain:popular_movies_usecase")
include(":features:feature_home")
include(":design_core")
include(":domain:top_rated_movies_usecase")
include(":domain:now_playing_usecase")
include(":domain:upcoming_usecase")
include(":features:feature_all_movies")
include(":domain:all_movies_usecase")
