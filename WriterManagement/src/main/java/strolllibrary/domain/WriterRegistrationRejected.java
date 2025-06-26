package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WriterRegistrationRejected extends AbstractEvent {

    private Long requestId;
    private String writerName;
    private String email;
    private String introduction;
    private String portfolioUrl;
    private WriterRegistrationStatus status;
    private Date reviewedAt;
    private String reviewedBy;
    private String reviewComment;

    public WriterRegistrationRejected(WriterProfile aggregate) {
        super(aggregate);
    }

    public WriterRegistrationRejected() {
        super();
    }
}
//>>> DDD / Domain Event
