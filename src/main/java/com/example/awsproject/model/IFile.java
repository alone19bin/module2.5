package com.example.awsproject.model;

import com.example.awsproject.model.enums.StatusFile;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString
@Table("files")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class IFile {

    @Id
    private Long id;
    private String location;
    private String fileName;

    @Enumerated(EnumType.STRING)
    private StatusFile status;


}
