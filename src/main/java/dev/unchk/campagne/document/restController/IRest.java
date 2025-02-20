package dev.unchk.campagne.document.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IRest {
    public String save(MultipartFile file) throws IOException;

    public ResponseEntity<byte[]> findById(String id) throws RuntimeException;

    public boolean delete(String id) throws RuntimeException;

}
