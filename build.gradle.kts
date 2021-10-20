import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("pl.allegro.tech.build.axion-release") version "1.13.3"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("com.palantir.docker") version "0.30.0"


    kotlin("plugin.jpa") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    kotlin("jvm") version "1.5.31"
}

group = "org.wagepage"
val version: String = scmVersion.version.toString()
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["testcontainersVersion"] = "1.16.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.h2database:h2:1.4.200")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

docker {
    name = "${rootProject.name}:$version"
    buildArgs(mapOf("version" to version))
    files(file("${buildDir}/libs/wagepage-$version.jar"))
}

val copyFrontend by tasks.registering(Copy::class) {
    destinationDir = buildDir.resolve("resources/main/static")
    from("$rootDir/src/main/frontend/public") {
        include("/**")
    }
}

tasks.processResources {
    dependsOn(copyFrontend)
}