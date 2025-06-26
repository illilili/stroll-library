package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SummaryGenerated extends AbstractEvent {

    private String summaryId;
    private String manuscriptId;
    private String content;
    private SummaryStatus status;
    private Date createdAt;
    private PublicationRequestId publicationRequestId;

    public SummaryGenerated(Summary aggregate) {
        super(aggregate);
    }

    public SummaryGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
