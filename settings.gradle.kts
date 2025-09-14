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
        // Add this line to fix the error
        maven { url = uri("https://jitpack.io") }
    }
}
rootProject.name = "FitX" // Your project name may be different
include(":app")