package spring.security.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.security.dto.NotebookDto;
import spring.security.security.mapper.NotebookMapperImpl;
import spring.security.security.model.Item;
import spring.security.security.model.Notebooks.Notebook;
import spring.security.security.repository.ItemRepository;
import spring.security.security.repository.NotebookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final NotebookRepository notebookRepository;
    public final NotebookMapperImpl notebookMapper;
    private final ItemRepository itemRepository;

    public List<NotebookDto> getNotebooks(){

        return notebookMapper.toDtoList(notebookRepository.findAll()) ;
    }
    public NotebookDto addNotebook(NotebookDto Notebook){
        Notebook notebook = notebookMapper.toModel(Notebook);
        Notebook savedNotebook = notebookRepository.save(notebook);

        Item item = Notebook.getItem();
        item.setNotebookId(savedNotebook.getId());
        itemRepository.save(item);
        return notebookMapper.toDto(savedNotebook);
    }

    public NotebookDto getNotebook(Long id){
        return notebookMapper.toDto(notebookRepository.findById(id).orElseThrow()) ;
    }
    public NotebookDto editNotebook(NotebookDto notebook){

        itemRepository.save(notebook.getItem());
        return notebookMapper.toDto(notebookRepository.save(notebookMapper.toModel(notebook))) ;
    }
    public void deleteNotebook(Long id){
        notebookRepository.deleteById(id);
    }

}
