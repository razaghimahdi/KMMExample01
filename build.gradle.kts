 /*
buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        classpath("com.android.tools.build:gradle:7.0.0")
        //classpath(Build.hiltGradlePlugin)
        classpath(Build.sqlDelightGradlePlugin)
    }
}*/
 buildscript {
     repositories {
         gradlePluginPortal()
         google()
         mavenCentral()
     }
     dependencies {
         classpath(Build.kotlinGradlePlugin)
         classpath(Build.buildTools)
         classpath(Build.sqlDelightGradlePlugin)
         classpath(Build.hiltGradlePlugin)
     }
 }

/*allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}*/

 allprojects {
     repositories {
         google()
         mavenCentral()
     }
 }

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}