package fr.fms.web;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/main/ressources/static")
public class ImageController {

    private static final String UPLOAD_DIR = "/main/ressources/static/";

    @PostMapping
    public ResponseEntity<String> uploadImage (@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(UPLOAD_DIR+ fileName));
            return ResponseEntity.ok("Image téléchargée avec succès");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image non téléchargée");
        }
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        try {
            Path imagePath = Paths.get(UPLOAD_DIR + imageName);
            Resource imageResource = (Resource) new UrlResource(imagePath.toUri());
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageResource);
        } catch (MalformedURLException e ) {
            return ResponseEntity.notFound().build();
        }
    }

}
