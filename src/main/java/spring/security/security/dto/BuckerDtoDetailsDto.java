package spring.security.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.security.model.Notebooks.Notebook;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuckerDtoDetailsDto {
    private Long notebookID;
    private String title;
    private Long notebookId;
    private BigDecimal price;
    private BigDecimal amount;
    private Double sum;
        public BuckerDtoDetailsDto(Notebook notebook){
            this.notebookID = notebook.getId();
            this.title = notebook.getName();
            this.notebookId = notebook.getId();
            this.price = notebook.getPrice();
            this.amount = new BigDecimal(1.0);
            this.sum = Double.valueOf(notebook.getPrice().toString());
        }
}
