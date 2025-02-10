package dev.unchk.campagne.document.restController;

import dev.unchk.campagne.document.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/document")
@AllArgsConstructor
public class RestImplSave implements IRest {

    private IService service;

    @PostMapping
    @Override
    public boolean save(@RequestParam("file") MultipartFile file) throws IOException {
        return service.save(file);
    }
}
