//package spring.security.security.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import spring.security.security.service.CourseService;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(value = "/api/course")
//public class CourseController {
//
//    private final CourseService courseService;
//    @GetMapping(value = "/get-course-list")
//    public List<CourseDto> getCourses(){
//        return courseService.getCourses();
//    }
//
//    @PostMapping(value = "/add-course")
//    public CourseDto addCourse(@RequestBody CourseDto course){
//            return courseService.addCourse(course);
//    }
//}
