package spring.security.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spring.security.security.service.UploadImageService;

@Controller
public class adminController {
    @Autowired
    private UploadImageService uploadImageService;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin-panel")
    public String adminPage(Model model){
        return "admin";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/upload-image/{id}")
    public String uploadImage(@RequestParam(name = "image") MultipartFile file,
                              @PathVariable(name = "id")Long id){
        uploadImageService.UploadPicture(file,id);
        return "redirect:/";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addLaptop")
    public String addLaptopPage(){
        return "addLaptop";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addPhone")
    public String addPhonePage(){
        return "addPhone";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addItems")
    public String addItemsPage(){
        return "addItems";
    }
}
