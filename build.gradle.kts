buildscript {
    dependencies {
        classpath(libs.google.services)
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
}

//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//        maven {
//            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
//        }
//        maven {
//            url = uri("https://oss.sonatype.org/content/repositories/releases")
//        }
//
//    }
//}
//import org.gradle.api.tasks.Delete
//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//        }
