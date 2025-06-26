package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class UserPointHistoryQuery {

    private String userId;
    private Date fromDate;
    private Date toDate;
}
