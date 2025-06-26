package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionCancelled extends AbstractEvent {

    private Long subscriptionId;
    private Long userId;
    private SubscriptionStatus status;
    private String cancelReason;
    private Date cancelledAt;

    public SubscriptionCancelled(Subscription aggregate) {
        super(aggregate);
    }

    public SubscriptionCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
