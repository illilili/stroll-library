package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SummaryGenerationFailed extends AbstractEvent {

    private String summaryId;
    private String manuscriptId;
    private SummaryStatus status;
    private String failureReason;
    private Date updatedAt;
    private PublicationRequestId publicationRequestId;

    public SummaryGenerationFailed(Summary aggregate) {
        super(aggregate);
    }

    public SummaryGenerationFailed() {
        super();
    }
}
//>>> DDD / Domain Event
