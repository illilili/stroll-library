package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptConversionFailed extends AbstractEvent {

    private String convertedManuscriptId;
    private String manuscriptId;
    private ManuscriptConvertStatus status;
    private String failureReason;
    private Date convertedAt;
    private PublicationRequestId publicationRequestId;

    public ManuscriptConversionFailed(ConvertedManuscript aggregate) {
        super(aggregate);
    }

    public ManuscriptConversionFailed() {
        super();
    }
}
//>>> DDD / Domain Event
