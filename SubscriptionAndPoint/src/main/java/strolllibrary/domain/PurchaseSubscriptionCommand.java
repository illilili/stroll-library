package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PurchaseSubscriptionCommand {

    private Long userId;
    private String subscriptionPlan;
    private Date startDate;
    private Date endDate;
}
