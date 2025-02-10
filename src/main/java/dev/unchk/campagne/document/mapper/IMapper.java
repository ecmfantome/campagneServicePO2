package dev.unchk.campagne.document.mapper;

import dev.unchk.campagne.document.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IMapper {
    public Document fileToDoc(MultipartFile file) throws RuntimeException, IOException;
}
