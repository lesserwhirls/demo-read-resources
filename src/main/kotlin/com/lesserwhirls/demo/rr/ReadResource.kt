package com.lesserwhirls.demo.rr

import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.nio.file.FileVisitOption
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Stream
import kotlin.io.path.extension


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