package spring.security.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketDto {
    private int amountNotebook;
    private Double sum;
    private List<BuckerDtoDetailsDto> bucketDetails= new ArrayList<>();
    public void aggregate(){
     this.amountNotebook = bucketDetails.size();
     this.sum = bucketDetails.stream()
             .map(BuckerDtoDetailsDto::getSum)
             .mapToDouble(Double::doubleValue)
             .sum();
    }

}
