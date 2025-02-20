package dev.unchk.campagne.document.mapper;

import dev.unchk.campagne.document.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class MapImpl implements IMapper {
    @Override
    public Document fileToDoc(MultipartFile file) throws RuntimeException, IOException {
        return Document.builder()
                .name(file.getOriginalFilename() + " - " + LocalDateTime.now().toString())
                .contentType(file.getContentType())
                .content(file.getBytes())
                .build();
    }
}
