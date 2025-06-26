package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SummaryStatusUpdated extends AbstractEvent {

    private String summaryId;
    private SummaryStatus status;
    private Date updatedAt;
    private String failureReason;

    public SummaryStatusUpdated(Summary aggregate) {
        super(aggregate);
    }

    public SummaryStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
