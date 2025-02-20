package dev.unchk.campagne.document.restController;

import dev.unchk.campagne.document.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/document")
@AllArgsConstructor
public class RestImplSave implements IRest {

    private IService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String save(@RequestPart("file") MultipartFile file) throws IOException {
        return service.save(file);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<byte[]> findById(@PathVariable String id) throws RuntimeException {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public boolean delete(@PathVariable String id) throws RuntimeException {
        return service.delete(id);
    }
}
