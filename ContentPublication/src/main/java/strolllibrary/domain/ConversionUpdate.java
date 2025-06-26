package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ConversionUpdate extends AbstractEvent {

    private Long publicationMetadataId;
    private String epubUrl;
    private String pdfUrl;
    private ConvertedManuscriptId convertedManuscriptId;
    private Date updatedAt;

    public ConversionUpdate(PublicationMetadata aggregate) {
        super(aggregate);
    }

    public ConversionUpdate() {
        super();
    }
}
//>>> DDD / Domain Event
