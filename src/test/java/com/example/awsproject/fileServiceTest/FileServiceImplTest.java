package com.example.awsproject.fileServiceTest;

import com.example.awsproject.service.FileService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class FileServiceImplTest {

    private final FileService s3Service = Mockito.mock(FileService.class);

    @Test
    void testCreateBucket() {
        s3Service.createBucket();
    }
}

