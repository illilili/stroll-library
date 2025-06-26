package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointsGranted extends AbstractEvent {

    private String userId;
    private Integer amount;
    private String reason;
    private Date grantedAt;
    private Integer totalPoints;

    public PointsGranted(User aggregate) {
        super(aggregate);
    }

    public PointsGranted() {
        super();
    }
}
//>>> DDD / Domain Event
