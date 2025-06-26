package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PointWalletHistoryQuery {

    private String pointWalletId;
    private Date fromDate;
    private Date toDate;
}
