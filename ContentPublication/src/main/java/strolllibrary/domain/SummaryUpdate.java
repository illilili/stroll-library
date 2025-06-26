package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SummaryUpdate extends AbstractEvent {

    private Date updatedAt;
    private String summary;
    private SummaryId summaryId;

    public SummaryUpdate(PublicationMetadata aggregate) {
        super(aggregate);
    }

    public SummaryUpdate() {
        super();
    }
}
//>>> DDD / Domain Event
