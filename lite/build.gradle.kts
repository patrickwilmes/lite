import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.springBootPlugin) version Versions.springBootVersion
    id(Plugins.springDependencyManagementPlugin) version Versions.springDependencyManagementVersion
    kotlin(Plugins.kotlinJvmPlugin) version Versions.kotlinVersion
    kotlin(Plugins.kotlinSpringPlugin) version Versions.kotlinVersion
    kotlin(Plugins.kotlinJpaPlugin) version Versions.kotlinVersion
}

group = "com.sevdesk.lite"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.springBootStarterDataJpa)
    implementation(Dependencies.springBootStarterWeb)
    implementation(Dependencies.jacksonModuleKotlin)
    implementation(Dependencies.kotlinReflect)
    implementation(Dependencies.kotlinStdLibJdk8)
    implementation(Dependencies.liquibaseCore)
    implementation(platform(Dependencies.arrowStack))
    implementation(Dependencies.arrowCore)

    runtimeOnly(Dependencies.h2Datbase)
    annotationProcessor(Dependencies.springBootAnnotationProcessor)

    testImplementation(Dependencies.springBootStarterTest)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.assertK)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
