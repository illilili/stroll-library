package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class CategoryAndFeeListQuery {

    private String manuscriptId;
    private String bookId;
    private String category;
    private CategoryFeeStatus status;
    private Date generatedAt;
}
