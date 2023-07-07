package spring.security.security.service;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadImageService {
    public void UploadPicture(MultipartFile file){
        try {
            if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")){
                byte bytes[]=file.getBytes();
                String filePath="build/resources/main/static/images";
                String fileName = DigestUtils.sha1Hex("image_Item") +"image.jpeg";
                Path path = Paths.get(filePath+fileName);
                Files.write(path, bytes);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
