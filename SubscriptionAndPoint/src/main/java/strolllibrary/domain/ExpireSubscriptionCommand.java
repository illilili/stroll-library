package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ExpireSubscriptionCommand {

    private Long subscriptionId;
    private Date expiredAt;
}
