package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CoverImageGenerationFailed extends AbstractEvent {

    private String coverImageId;
    private String manuscriptId;
    private CoverImageStatus status;
    private String failureReason;
    private Date updatedAt;
    private PublicationRequestId publicationRequestId;

    public CoverImageGenerationFailed(CoverImage aggregate) {
        super(aggregate);
    }

    public CoverImageGenerationFailed() {
        super();
    }
}
//>>> DDD / Domain Event
