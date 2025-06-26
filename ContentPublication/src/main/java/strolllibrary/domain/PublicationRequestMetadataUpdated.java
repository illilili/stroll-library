package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PublicationRequestMetadataUpdated extends AbstractEvent {

    private Long publicationRequestId;
    private String coverImageUrl;
    private String summary;
    private String category;
    private Double subscriptionPrice;
    private String epubUrl;
    private String pdfUrl;
    private Date updatedAt;

    public PublicationRequestMetadataUpdated(PublicationRequest aggregate) {
        super(aggregate);
    }

    public PublicationRequestMetadataUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
