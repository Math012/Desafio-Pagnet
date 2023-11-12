package com.math012.projectpagNet.service;

import com.math012.projectpagNet.model.CnabModel;
import com.math012.projectpagNet.repository.CnabRepository;
import com.math012.projectpagNet.utils.StorageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class CnabService {

    private final Path fileStorageLocation;

    @Autowired
    CnabRepository repository;

    @Autowired
    public CnabService(StorageConfig storageConfig){
        Path path = Paths.get(storageConfig.getUpload_dir()).toAbsolutePath().normalize();
        this.fileStorageLocation = path;
    }

    public String uploadCnabDocument(MultipartFile file) throws Exception {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = this.fileStorageLocation;
        try{
            if (filename.contains("..")) throw new Exception("name invalid");
            Path location = path.resolve(filename);
            Files.copy(file.getInputStream(),location, StandardCopyOption.REPLACE_EXISTING);
            return fileStorageLocation+"//"+filename;
        }catch (Exception e){
            throw new Exception("name invalid");
        }
    }
}
