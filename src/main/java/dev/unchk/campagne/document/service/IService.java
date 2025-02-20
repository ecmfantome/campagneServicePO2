package dev.unchk.campagne.document.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IService {
    public String save(MultipartFile file) throws IOException;

    public ResponseEntity<byte[]> findById(String userId) throws RuntimeException;

    public boolean delete(String id) throws RuntimeException;

}
