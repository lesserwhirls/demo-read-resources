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

package com.lesserwhirls.demo.rr

import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.nio.file.FileVisitOption
import java.nio.file.Files
import java.nio.file.Paths

class ReadResource {
    companion object {
        fun main() {
            val scriptDir = "/migrations/"
            this::class.java.getResource(scriptDir)
                ?.toURI()
                ?.let { uri ->
                    if (uri.scheme.equals("jar")) {
                        val fileSystem: FileSystem = FileSystems.newFileSystem(uri, emptyMap<String, Any>())
                        fileSystem.getPath(scriptDir)
                    } else {
                        Paths.get(uri)
                    }
                }.let { scriptPath ->
                    Files.walk(scriptPath, 1, FileVisitOption.FOLLOW_LINKS)
                        .filter {it.toString().endsWith(".js")}
                        .sorted()
                        .forEach() { migrationScript ->
                        println(scriptDir + migrationScript.fileName)
                    }
                }
        }
    }
}

fun main() {
    ReadResource.main()
}