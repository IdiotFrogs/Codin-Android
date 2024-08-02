pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Codin"
include(":app")
include(":common:extension")
include(":common:resource")
include(":common:notification")
include(":core:navigation")
include(":core:network")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:designsystem")
include(":core:datastore")
include(":feature:home")
include(":feature:calender")
include(":feature:insight")
include(":feature:login")
include(":feature:setting")
include(":widget")
