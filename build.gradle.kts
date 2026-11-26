plugins {
    kotlin("jvm") version "2.4.21" apply false
    id("com.google.devtools.ksp") version "2.3.14" apply false
}

allprojects {
    group = "dev.omakasekim.boron"
    version = "0.3.0"
    repositories { mavenCentral() }
}
