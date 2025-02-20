package dev.unchk.campagne.document.service;

import dev.unchk.campagne.document.Document;
import dev.unchk.campagne.document.DocumentRepository;
import dev.unchk.campagne.document.mapper.IMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
@AllArgsConstructor
public class ServiceImplSave implements IService {

    private DocumentRepository documentRepository;
    private IMapper mapper;

    @Override
    public String save(MultipartFile file) throws IOException {
        Document document = mapper.fileToDoc(file);
        documentRepository.save(document);
        return document.getId();

    }

    @Override
    public ResponseEntity<byte[]> findById(String id) throws RuntimeException {
        Document document = documentRepository.findById(id).orElseThrow(RuntimeException::new);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, document.getContentType())
                .body(document.getContent());
    }

    @Override
    public boolean delete(String id) throws RuntimeException {
        documentRepository.deleteById(id);
        return true;
    }
}
