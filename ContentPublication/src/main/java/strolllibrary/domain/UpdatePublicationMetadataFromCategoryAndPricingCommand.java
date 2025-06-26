package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdatePublicationMetadataFromCategoryAndPricingCommand {

    private Long publicationMetadataId;
    private CategoryAndFeeId categoryAndFeeId;
    private String category;
    private Double subscriptionPrice;
}
