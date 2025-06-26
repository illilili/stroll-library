package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CoverUpdated extends AbstractEvent {

    private Long publicationMetadataId;
    private CoverImageId coverImageId;
    private String coverImageUrl;
    private Date updatedAt;

    public CoverUpdated(PublicationMetadata aggregate) {
        super(aggregate);
    }

    public CoverUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
