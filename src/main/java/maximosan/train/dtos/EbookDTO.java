package maximosan.train.dtos;
import lombok.Data;

@Data
public class EbookDTO {
    private String preview_url;
    private String availability;
    private Object formats;
    private String borrow_url;
    private Boolean checkedout;
}