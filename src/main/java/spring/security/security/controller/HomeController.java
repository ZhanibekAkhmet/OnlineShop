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
import spring.security.security.dto.BucketDto;
import spring.security.security.model.User;
import spring.security.security.service.BucketService;
import spring.security.security.service.NotebookService;
import spring.security.security.service.UploadImageService;
import spring.security.security.service.UserService;

import java.security.Principal;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadImageService uploadImageService;
    @Autowired
    private NotebookService notebookService;
    @Autowired
    private BucketService bucketService;
    @GetMapping(value = "/addLaptop")
    public String addLaptopPage(){
        return "addLaptop";
    }
    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }
    @GetMapping(value = "/detailsLaptop/{id}")
    public String detailsPage(){
        return "details";
    }
    @GetMapping(value = "/sign-in-page")
    public String signinnPage(){
        return "signin";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage(){
        return "profile";
    }
    @GetMapping(value = "/403-page")
    public String accesDenied(){
        return "403";
    }
    @GetMapping(value = "/update-password-page")
    public String updatepasswordPage(){
        return "update-password";
    }
    @GetMapping(value = "/sign-up-page")
    public String signupPage(){
        return "signup";
    }
    @PostMapping(value = "/to-sign-up")
    public String tosignupPage(@RequestParam(name = "user_email") String email,
                               @RequestParam(name = "user_password") String password,
                               @RequestParam(name = "user_repeat_password") String repeat_password,
                               @RequestParam(name = "user_full_name") String full_name){
        if (password.equals(repeat_password)){
            User user = new User();
            user.setEmail(email);
            user.setFullName(full_name);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/sign-up-page?success";
            } else {
                return "redirect:/sign-up-page?emailerror";
            }
        } else {
            return "redirect:/sign-up-page?passworderror";
        }

    }
    @PostMapping(value = "/to-update-password")
    public String toUpdatePassword(@RequestParam(name = "user_old_password") String old_password,
                               @RequestParam(name = "user_new_password") String new_password,
                               @RequestParam(name = "user_repeat_new_password") String repeat_new_password){
                if (new_password.equals(repeat_new_password)){
                        User user = userService.updatePassword(new_password, old_password);
                        if (user!=null){
                            return "redirect:/update-password-page? ";
                        }else {
                            return "redirect:/update-password-page?oldpassworderror";
                        }
                }else {
                    return "redirect:/update-password-page?passwordmismatch";
                }
    }
    @PostMapping(value = "/upload-image")
    public String uploadImage(@RequestParam(name = "image")MultipartFile file){
        uploadImageService.UploadPicture(file);
        return "redirect:/addLaptop";
    }
    @GetMapping  (value = "/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        if (principal==null){
            return "redirect:/";
        }
        notebookService.addToUserBucket(id,principal.getName());
        return "redirect:/";
    }
    @GetMapping  (value = "/bucket")
    public String datailsBucket(Model model, Principal principal){
        if (principal==null){
            model.addAttribute("bucket", new BucketDto());
        }else {
            BucketDto bucketDto = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDto);
        }
        return "bucket";
    }
    @GetMapping  (value = "/{id}/bucketDelete")
    public String deleteBucket(@PathVariable Long id, Principal principal){
        if (principal==null){
            return "redirect:/";
        }
        notebookService.removeNotebookFromBucketByUser(principal.getName(),id);
        return "redirect:/bucket";
    }
}
