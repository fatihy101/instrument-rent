package com.enstrurental.server.services


import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.util.stream.Stream

interface FileStorage {
    fun store(file: MultipartFile)
    fun loadFile(filename: String): ServerProperties.Tomcat.Resource
    fun deleteAll()
    fun init()
    fun loadFiles(): Stream<Path>
}