package dev.unchk.campagne.document.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IService {
    public boolean save(MultipartFile file) throws IOException;
}
