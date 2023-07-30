package spring.security.security.service;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.security.security.model.Item;
import spring.security.security.repository.ItemRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadImageService {
    @Autowired
    private ItemRepository itemRepository;
    @Value("${targetURL}")
    private String targetURL;
    public void UploadPicture(MultipartFile file, Long itemID){
        try {
            if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")){
                byte bytes[]=file.getBytes();
                Item item = itemRepository.findById(itemID).orElseThrow();
                String fileName = DigestUtils.sha1Hex(item.getId()+"image_Item")+"image.jpg";
                Path path = Paths.get(targetURL+fileName);
                Files.write(path, bytes);
                item.setImage(fileName);
                itemRepository.save(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
