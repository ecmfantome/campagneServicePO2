package dev.unchk.campagne.document.service;

import dev.unchk.campagne.document.Document;
import dev.unchk.campagne.document.DocumentRepository;
import dev.unchk.campagne.document.mapper.IMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@Service
@Transactional
@AllArgsConstructor
public class ServiceImplSave implements IService {

    private DocumentRepository documentRepository;
    private IMapper mapper;

    @Override
    public boolean save(MultipartFile file) throws IOException {
        Document document = mapper.fileToDoc(file);
        System.out.println("file.getName() ===========" + document.getName());
        System.out.println("file.getContentType() ===========" + document.getContentType());
        System.out.println("file.getContent() ===========" + Arrays.toString(document.getContent()));

        documentRepository.save(document);
        return true;
    }
}
