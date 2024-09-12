package com.example.awsproject.rest.api;


import com.example.awsproject.model.IFile;
import com.example.awsproject.rest.FileRestControllerV1;
import com.example.awsproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FileRestControllerV1Impl implements FileRestControllerV1 {

    private final FileService fileService;

    @Override
    @PostMapping
    public ResponseEntity<PutObjectResponse> upload(@RequestBody IFile file) {
        return ResponseEntity.ok(fileService.upload(file));
    }

    @Override
    @PutMapping
    public ResponseEntity<?> download(@RequestBody IFile file) {
        var resource = new InputStreamResource(fileService.downloadFile(file));
        return new ResponseEntity<>(resource,  HttpStatus.OK);
    }

}