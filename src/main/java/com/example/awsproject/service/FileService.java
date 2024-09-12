package com.example.awsproject.service;



import com.example.awsproject.model.IFile;

import java.io.InputStream;

import software.amazon.awssdk.services.s3.model.PutObjectResponse;

public interface FileService {
    //@SneakyThrows
    void createBucket();
   // @SneakyThrows
    void listBuckets();
    //@SneakyThrows
    void deleteBucket(String bucketName);
    //@SneakyThrows
    void deleteFile(String fileName);
   // @SneakyThrows
   PutObjectResponse upload(IFile file);
   // @SneakyThrows
    InputStream downloadFile(IFile file);
}
