package spring.security.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.security.model.BaseModel;
import spring.security.security.model.Notebooks.Notebook;
import spring.security.security.model.User;

import java.util.List;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Bucket extends BaseModel {
    @OneToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Notebook> notebooks;
}
