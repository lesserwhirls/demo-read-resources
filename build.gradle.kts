import org.jetbrains.kotlin.gradle.targets.js.npm.versionToNpmRanges

/*
 * Copyright 2022 Sean C. Arms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        attributes(
            "Main-Class" to "com.lesserwhirls.demo.rr.ReadResourceKt",
        )
    }
    from("LICENSE") {
        into("META-INF/")
    }
}

application {
    mainClass.set("com.lesserwhirls.demo.rr.ReadResourceKt")
}
