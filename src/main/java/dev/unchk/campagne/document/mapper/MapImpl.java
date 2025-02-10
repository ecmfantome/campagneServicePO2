package dev.unchk.campagne.document.mapper;

import dev.unchk.campagne.document.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MapImpl implements IMapper {
    @Override
    public Document fileToDoc(MultipartFile file) throws RuntimeException, IOException {
        return Document.builder()
                .name(file.getOriginalFilename())
                .contentType(file.getContentType())
                .content(file.getBytes())
                .build();
    }
}
