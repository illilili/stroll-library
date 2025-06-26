package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CancelSubscriptionCommand {

    private Long subscriptionId;
    private String cancelReason;
    private Date cancelledAt;
}
