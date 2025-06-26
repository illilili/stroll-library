package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BookListQuery {

    private String title;
    private AuthorName authorName;
    private Integer viewCount;
    private Boolean bestsellerBadge;
    private BookStatus status;
}
