plugins {
    kotlin("jvm") version "1.7.10"
    `application`
}

group = "com.lesserwhirls.demo"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.lesserwhirls.demo.rr.ReadResourceKt"
    }
}

application {
    mainClass.set("com.lesserwhirls.demo.rr.ReadResourceKt")
}
