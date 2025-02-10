package dev.unchk.campagne.document.restController;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IRest {
    public boolean save(MultipartFile file) throws IOException;
}
