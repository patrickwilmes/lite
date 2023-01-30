object Dependencies {
    val springBootStarterDataJpa = "org.springframework.boot:spring-boot-starter-data-jpa"
    val springBootStarterWeb = "org.springframework.boot:spring-boot-starter-web"
    val jacksonModuleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"
    val kotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    val liquibaseCore = "org.liquibase:liquibase-core"
    val arrowStack = "io.arrow-kt:arrow-stack:${Versions.arrowStackVersion}"
    val arrowCore = "io.arrow-kt:arrow-core"

    val h2Datbase = "com.h2database:h2"
    val springBootAnnotationProcessor = "org.springframework.boot:spring-boot-configuration-processor"

    val springBootStarterTest = "org.springframework.boot:spring-boot-starter-test"
    val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    val assertK = "com.willowtreeapps.assertk:assertk-jvm:${Versions.assertKVersion}"
}
