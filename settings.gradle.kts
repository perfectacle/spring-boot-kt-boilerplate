val projectName: String by settings
rootProject.name = projectName

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            val kotlinVersion: String by settings
            val springBootVersion: String by settings
            val springBootDependencyManagementVersion: String by settings

            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springBootDependencyManagementVersion)
            }
        }
    }
}
