package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BadgeHistoryQuery {

    private BookId bookId;
    private BadgeType type;
    private Date grantedAt;
}
