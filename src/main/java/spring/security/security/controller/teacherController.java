package spring.security.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class teacherController {
    @PreAuthorize("hasAnyRole('ROLE_TEACHER','ROLE_ADMIN')")
    @GetMapping(value = "/teacher-panel")
    public String adminPage(Model model){
        return "teacher";
    }
}
