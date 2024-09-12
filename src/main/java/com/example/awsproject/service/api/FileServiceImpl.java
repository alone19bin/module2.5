package com.example.awsproject.service.api;


import com.example.awsproject.model.IFile;
import com.example.awsproject.repository.FileRepository;
import com.example.awsproject.service.FileService;
import com.example.awsproject.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.InputStream;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final S3Client s3Client;

    @Value("${spring.cloud.aws.credentials.bucketName}")
    private String bucketName;

    @Override
    public void createBucket() {
        boolean bucketExists = s3Client.listBuckets().buckets().stream()
                .anyMatch(b -> b.name().equals(bucketName));
        if (bucketExists) {
            log.info("Bucket {} already exists, use a different name", bucketName);
            return;
        }

        s3Client.createBucket(CreateBucketRequest.builder()
                .bucket(bucketName)
                .build());
    }

    @Override
    public void listBuckets() {
        List<Bucket> buckets = s3Client.listBuckets().buckets();
        log.info("buckets: {}", buckets);
        System.out.println(buckets);
    }

    @Override
    public void deleteBucket(String bucketName) {
        s3Client.deleteBucket(DeleteBucketRequest.builder()
                .bucket(bucketName)
                .build());
        log.info("delete Bucket {}", bucketName);
    }

    @Override
    public void deleteFile(String fileName) {
        s3Client.deleteObject(DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build());
        log.info("Bucket {} deleteFile ", fileName);
    }

    @Override
    public PutObjectResponse upload(IFile file) {
        return s3Client.putObject(PutObjectRequest.builder()
                .bucket(bucketName)
                .key(file.getFileName())
                .build(), file.getFilePath());
    }

    @Override
    public InputStream downloadFile(IFile file) {
        log.info("Bucket {} downloadFile ", file);
        ResponseInputStream<GetObjectResponse> response = s3Client.getObject(GetObjectRequest.builder()
                .bucket(bucketName)
                .key(file.getFileName())
                .build());
        return response.response().body().asInputStream();
    }
}

