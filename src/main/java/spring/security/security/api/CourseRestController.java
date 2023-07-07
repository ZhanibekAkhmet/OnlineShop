//package spring.security.security.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import spring.security.security.service.CourseService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/course")
//@RequiredArgsConstructor
//public class CourseRestController {
//    private final CourseService courseService;
//    @GetMapping
//    public List<CourseDto> courseList(){
//        return courseService.getCourses();
//    }
//    @GetMapping(value = "{id}")
//    public CourseDto   getCourse(@PathVariable(name = "id") Long id){
//        return courseService.getCourse(id);
//    }
//    @PostMapping
//    public CourseDto addCourse(@RequestBody CourseDto course){
//        return courseService.addCourse(course);
//    }
//    @PutMapping
//    public CourseDto editCourse(@RequestBody CourseDto course){
//        return courseService.editCourse(course);
//    }
//    @DeleteMapping(value = "{id}")
//    public void deleteCourse(@PathVariable(name = "id")Long id){
//        courseService.deleteCourse(id);
//    }
//}
