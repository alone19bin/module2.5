package com.example.awsproject.repository;


import com.example.awsproject.model.IFile;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends R2dbcRepository<IFile,Long> {
}
