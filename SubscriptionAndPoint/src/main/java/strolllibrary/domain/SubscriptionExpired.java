package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionExpired extends AbstractEvent {

    private Long subscriptionId;
    private Long userId;
    private SubscriptionStatus status;
    private Date expiredAt;

    public SubscriptionExpired(Subscription aggregate) {
        super(aggregate);
    }

    public SubscriptionExpired() {
        super();
    }
}
//>>> DDD / Domain Event
