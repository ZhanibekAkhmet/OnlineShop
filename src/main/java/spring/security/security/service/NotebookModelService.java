package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.model.Notebooks.NotebookModel;
import spring.security.security.repository.NotebookModelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookModelService {
    private final NotebookModelRepository notebookModelRepository;

    public List<NotebookModel> getNotebookModels(){
        return notebookModelRepository.findAll();
    }
    public NotebookModel addNotebookModel(NotebookModel notebookModel){
        return notebookModelRepository.save(notebookModel);
    }
    public NotebookModel getNotebookModel(Long id){
        return notebookModelRepository.findById(id).orElseThrow();
    }
    public NotebookModel editNotebookModel(NotebookModel notebookModel){
        return notebookModelRepository.save(notebookModel);
    }
    public void deleteNotebookModel(Long id){
        notebookModelRepository.deleteById(id);
    }
}
