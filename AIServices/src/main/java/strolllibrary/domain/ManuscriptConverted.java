package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptConverted extends AbstractEvent {

    private String convertedManuscriptId;
    private String manuscriptId;
    private String epubUrl;
    private String pdfUrl;
    private ManuscriptConvertStatus status;
    private Date convertedAt;
    private PublicationRequestId publicationRequestId;

    public ManuscriptConverted(ConvertedManuscript aggregate) {
        super(aggregate);
    }

    public ManuscriptConverted() {
        super();
    }
}
//>>> DDD / Domain Event
