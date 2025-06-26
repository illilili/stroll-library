package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CoverImageStatusUpdated extends AbstractEvent {

    private String coverImageId;
    private CoverImageStatus status;
    private Date updatedAt;
    private String failureReason;

    public CoverImageStatusUpdated(CoverImage aggregate) {
        super(aggregate);
    }

    public CoverImageStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
