package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointsConsumed extends AbstractEvent {

    private String userId;
    private Integer amount;
    private String contentId;
    private Date consumedAt;
    private Integer totalPoints;

    public PointsConsumed(User aggregate) {
        super(aggregate);
    }

    public PointsConsumed() {
        super();
    }
}
//>>> DDD / Domain Event
