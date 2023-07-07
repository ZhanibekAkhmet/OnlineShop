package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Notebooks.Test;
import spring.security.security.repository.TestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public List<Test> getTests(){
        return testRepository.findAll();
    }
    public Test updateTest(Test test){
        return testRepository.save(test);
    }
}
