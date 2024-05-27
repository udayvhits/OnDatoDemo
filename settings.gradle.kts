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
        jcenter()
        maven { url = uri("https://jitpack.io") }

        maven {
            url = uri("https://raw.githubusercontent.com/ondato/ondato-sdk-android/main/repos/")
        }
    }
}

rootProject.name = "KYCDemo"
include(":app")
 