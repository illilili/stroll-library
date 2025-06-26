package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PromotionMessageDisplayed extends AbstractEvent {

    private Long promotionMessageId;
    private UserId userId;
    private PromotionType promotionType;
    private String message;
    private Date displayedAt;
    private Date createdAt;

    public PromotionMessageDisplayed(PromotionMessage aggregate) {
        super(aggregate);
    }

    public PromotionMessageDisplayed() {
        super();
    }
}
//>>> DDD / Domain Event
