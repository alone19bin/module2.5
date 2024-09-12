package com.example.awsproject.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;

import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;



@Configuration
public class S3Config {

    @Value("${spring.cloud.aws.credentials.aws_access_key_id}")
    private String keyId;
    @Value("${spring.cloud.aws.credentials.aws_secret_access_key}")
    private String secretKey;
    @Value("${spring.cloud.aws.credentials.region}")
    private String region;
    @Value("${spring.cloud.aws.credentials.serviceEndpoint}")
    private String serviceEndpoint;


    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("your-access-key", "your-secret-key");

        return S3Client.builder()
                .region(Region.US_WEST_2)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }

}