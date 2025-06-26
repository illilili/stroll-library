package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CoverImageGenerated extends AbstractEvent {

    private String coverImageId;
    private String manuscriptId;
    private String imageUrl;
    private CoverImageStatus status;
    private Date createdAt;
    private PublicationRequestId publicationRequestId;

    public CoverImageGenerated(CoverImage aggregate) {
        super(aggregate);
    }

    public CoverImageGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
