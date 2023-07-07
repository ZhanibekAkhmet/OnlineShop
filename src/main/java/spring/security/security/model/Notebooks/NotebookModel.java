package spring.security.security.model.Notebooks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.security.model.BaseModel;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class NotebookModel extends BaseModel {
    @Column(name = "name")
    private String name;
}
