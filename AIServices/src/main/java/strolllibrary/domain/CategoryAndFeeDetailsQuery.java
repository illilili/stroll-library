package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class CategoryAndFeeDetailsQuery {

    private String categoryAndFeeId;
    private String manuscriptId;
    private String bookId;
    private CategoryFeeStatus status;
}
