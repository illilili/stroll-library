package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CategoryAndFeeGenerated extends AbstractEvent {

    private String categoryAndFeeId;
    private String manuscriptId;
    private String bookId;
    private String category;
    private Double feeAmount;
    private String currency;
    private CategoryFeeStatus status;
    private Date generatedAt;
    private PublicationRequestId publicationRequestId;

    public CategoryAndFeeGenerated(CategoryAndFee aggregate) {
        super(aggregate);
    }

    public CategoryAndFeeGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
