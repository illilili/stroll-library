package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CategoryAndPricingGenerated extends AbstractEvent {

    private Long publicationMetadataId;
    private CategoryAndFeeId categoryAndFeeId;
    private String category;
    private Double subscriptionPrice;
    private Date updatedAt;

    public CategoryAndPricingGenerated(PublicationMetadata aggregate) {
        super(aggregate);
    }

    public CategoryAndPricingGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
