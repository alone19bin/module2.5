package com.example.awsproject.rest;


import com.example.awsproject.model.IFile;
import org.springframework.http.ResponseEntity;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

public interface FileRestControllerV1 {
    ResponseEntity<PutObjectResponse> upload(IFile file);
    ResponseEntity<?> download(IFile file);
}