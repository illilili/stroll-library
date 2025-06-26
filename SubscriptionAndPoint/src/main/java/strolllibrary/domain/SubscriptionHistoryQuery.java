package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class SubscriptionHistoryQuery {

    private Long userId;
    private SubscriptionStatus status;
    private Date startDate;
    private Date endDate;
}
