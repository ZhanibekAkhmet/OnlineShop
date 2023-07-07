package spring.security.security.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;
import spring.security.security.dto.NotebookDto;
import spring.security.security.mapper.NotebookMapper;
import spring.security.security.mapper.NotebookMapperImpl;
import spring.security.security.model.Bucket;
import spring.security.security.model.Notebooks.Notebook;
import spring.security.security.model.Notebooks.Processor;
import spring.security.security.model.User;
import spring.security.security.repository.NotebookRepository;
import spring.security.security.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final NotebookRepository notebookRepository;
    public final NotebookMapperImpl notebookMapper;
    private final BucketService bucketService;
    private final UserService userService;
    private final UserRepository userRepository;
    @Transactional
    public  void addToUserBucket(Long notebookId, String username){
        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new RuntimeException("User not found"+ username);
        }
        Bucket bucket = user.getBucket();
        if (bucket==null){
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(notebookId));
            user.setBucket(newBucket);
            userRepository.save(user);
        }else {
            bucketService.addNotebooksInBucket(bucket,Collections.singletonList(notebookId));
        }
    }
    public void removeNotebookFromBucketByUser(String name, Long notebookId) {
        User user = userRepository.findByEmail(name);
        if (user == null || user.getBucket() == null) {
            return;
        }
        bucketService.removeNotebookFromBucket(user.getBucket(),notebookId);
    }
//    @Transactional
//    public  void deleteToUserBucket(Long notebookId, String username){
//        User user = userRepository.findByEmail(username);
//        if (user == null){
//            throw new RuntimeException("User not found"+ username);
//        }
//        Bucket bucket = user.getBucket();
//        if (bucket==null){
//            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(notebookId));
//            user.setBucket(newBucket);
//            userRepository.save(user);
//        }else {
//            bucketService.addNotebooksInBucket(bucket,Collections.singletonList(notebookId));
//        }
//    }
    public List<NotebookDto> getNotebooks(){

        return notebookMapper.toDtoList(notebookRepository.findAll()) ;
    }
    public NotebookDto addNotebook(NotebookDto Notebook){
        return notebookMapper.toDto(notebookRepository.save(notebookMapper.toModel(Notebook)));
    }
    public NotebookDto getNotebook(Long id){
        return notebookMapper.toDto(notebookRepository.findById(id).orElseThrow()) ;
    }
    public NotebookDto editNotebook(NotebookDto notebook){
        return notebookMapper.toDto(notebookRepository.save(notebookMapper.toModel(notebook))) ;
    }
    public void deleteNotebook(Long id){
        notebookRepository.deleteById(id);
    }

}
