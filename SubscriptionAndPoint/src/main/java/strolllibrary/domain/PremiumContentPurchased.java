package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PremiumContentPurchased extends AbstractEvent {

    private String userId;
    private String contentId;
    private Integer pointsUsed;
    private Date purchaseDate;

    public PremiumContentPurchased(User aggregate) {
        super(aggregate);
    }

    public PremiumContentPurchased() {
        super();
    }
}
//>>> DDD / Domain Event
