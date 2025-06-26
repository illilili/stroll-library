package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdatePublicationMetadataFromSummaryCommand {

    private Long publicationMetadataId;
    private SummaryId summaryId;
    private String summary;
}
