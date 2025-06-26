package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointExhausted extends AbstractEvent {

    private String userId;
    private Date exhaustedAt;

    public PointExhausted(User aggregate) {
        super(aggregate);
    }

    public PointExhausted() {
        super();
    }
}
//>>> DDD / Domain Event
