package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionPurchased extends AbstractEvent {

    private Long subscriptionId;
    private Long userId;
    private String subscriptionPlan;
    private SubscriptionStatus status;
    private Date startDate;
    private Date endDate;
    private Date purchasedAt;

    public SubscriptionPurchased(Subscription aggregate) {
        super(aggregate);
    }

    public SubscriptionPurchased() {
        super();
    }
}
//>>> DDD / Domain Event
