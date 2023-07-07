//package spring.security.security.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import spring.security.security.dto.BucketDto;
//import spring.security.security.model.Notebooks.NotebookModel;
//import spring.security.security.service.BucketService;
//import spring.security.security.service.NotebookModelService;
//
//import java.security.Principal;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/bucket")
//@RequiredArgsConstructor
//public class BucketRestController {
//    private final BucketService bucketService;
//    @GetMapping
//    public BucketDto bucketDto(Principal principal){
//
//        return bucketService.getBucketByUser(principal.getName());
//    }
//
//
//}
