package spring.security.security.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.springframework.stereotype.Service;
import spring.security.security.dto.BuckerDtoDetailsDto;
import spring.security.security.dto.BucketDto;
import spring.security.security.model.Bucket;
import spring.security.security.model.Notebooks.Notebook;
import spring.security.security.model.User;
import spring.security.security.repository.BucketRepozitory;
import spring.security.security.repository.NotebookRepository;
import spring.security.security.repository.UserRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BucketService {

    private final BucketRepozitory bucketRepozitory;
    private final NotebookRepository notebookRepository;
    private final UserRepository userRepository;

    @Transactional
    public Bucket createBucket(User user, List<Long> notebookId){
        Bucket bucket = new Bucket();
        bucket.setUser(user);
        List<Notebook> notebookList= getCollectRefNotebooksById(notebookId);
        bucket.setNotebooks(notebookList);
        return bucketRepozitory.save(bucket);
    }
    private List<Notebook> getCollectRefNotebooksById(List<Long> notebookId){
        return notebookId.stream()
                .map(notebookRepository::getOne)
                .collect(Collectors.toList());
    }
    @Transactional
    public void addNotebooksInBucket(Bucket bucket,List<Long> notebooksIds){
        List<Notebook> notebooks = bucket.getNotebooks();
        List<Notebook> newNotebooksList = notebooks == null ? new ArrayList<>() : new ArrayList<>(notebooks);
        newNotebooksList.addAll(getCollectRefNotebooksById(notebooksIds));
        bucket.setNotebooks(newNotebooksList);
        bucketRepozitory.save(bucket);
    }
//    @Transactional
//    public void deleteNetbook(Bucket bucket, List<Long> notId){
//        List<Notebook> notebooks = bucket.getNotebooks();
//        List<Notebook> newNotebooksList = notebooks == null ? new ArrayList<>() : new ArrayList<>(notebooks);
//        newNotebooksList.remove(getCollectRefNotebooksById(notId));
//        bucket.setNotebooks(newNotebooksList);
//        bucketRepozitory.save(bucket);
//    }
    public void removeNotebookFromBucket(Bucket bucket, Long notebookId) {
    List<Notebook> notebooks = bucket.getNotebooks();
    if (notebooks == null) {
        return;
    }

    notebooks.removeIf(notebook -> notebook.getId().equals(notebookId));
    bucketRepozitory.save(bucket);
    }
    public BucketDto getBucketByUser(String name){
        User user = userRepository.findByEmail(name);
        if (user==null || user.getBucket()==null){
            return new BucketDto();
        }

        BucketDto bucketDto = new BucketDto();
        Map<Long, BuckerDtoDetailsDto> mapByNotebookId = new HashMap<>();
        List<Notebook> notebooks = user.getBucket().getNotebooks();
            for (Notebook notebook: notebooks){
                BuckerDtoDetailsDto detail = mapByNotebookId.get(notebook.getId());
                if (detail==null){
                    mapByNotebookId.put(notebook.getId(), new BuckerDtoDetailsDto(notebook));
                }else {
                    detail.setAmount(detail.getAmount().add(new BigDecimal(1.0)));
                    detail.setSum(detail.getSum()+Double.valueOf(notebook.getPrice().toString()));
                }
            }

            bucketDto.setBucketDetails(new ArrayList<>(mapByNotebookId.values()));
            bucketDto.aggregate();
            return bucketDto;
    }
}
