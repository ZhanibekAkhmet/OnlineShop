package spring.security.security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.security.security.dto.NotebookDto;
import spring.security.security.model.Notebooks.Test;
import spring.security.security.service.TestService;

import java.util.List;

@RestController
@RequestMapping(value = "/updateTest")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public List<Test> getTests(){
        return testService.getTests();
    }

    @PutMapping
    public Test updateTest(@RequestBody Test test){
        return testService.updateTest(test);
    }
}
