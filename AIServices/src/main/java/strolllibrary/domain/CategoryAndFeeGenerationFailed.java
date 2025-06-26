package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CategoryAndFeeGenerationFailed extends AbstractEvent {

    private String categoryAndFeeId;
    private String manuscriptId;
    private CategoryFeeStatus status;
    private String failureReason;
    private Date generatedAt;
    private PublicationRequestId publicationRequestId;

    public CategoryAndFeeGenerationFailed(CategoryAndFee aggregate) {
        super(aggregate);
    }

    public CategoryAndFeeGenerationFailed() {
        super();
    }
}
//>>> DDD / Domain Event
