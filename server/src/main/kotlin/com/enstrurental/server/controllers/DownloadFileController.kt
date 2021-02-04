package com.enstrurental.server.controllers

import com.enstrurental.server.services.FileInfo
import com.enstrurental.server.services.FileStorage
import jdk.internal.loader.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.stream.Collectors

@Controller
class DownloadFileController {
    @Autowired
    lateinit var fileStorage: FileStorage

    @GetMapping("/files")
    fun getListFiles(model: Model): String {
        val fileInfos: List<FileInfo> = fileStorage.loadFiles().map{
                path -> FileInfo(path.getFileName().toString(),
            MvcUriComponentsBuilder.fromMethodName(DownloadFileController::class.java,
                "downloadFile", path.getFileName().toString()).build().toString())
        }
            .collect(Collectors.toList())

        model.addAttribute("files", fileInfos)
        return "multipartfile/listfiles"
    }


    @GetMapping("/files/{filename}")
    fun downloadFile(@PathVariable filename: String): ResponseEntity<Resource> {
        val file = fileStorage.loadFile(filename)
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
            .body(file);
    }
}