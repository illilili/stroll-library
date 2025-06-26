package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdatePublicationRequestMetadataCommand {

    private Long publicationRequestId;
    private String coverImageUrl;
    private String summary;
    private String category;
    private Double subscriptionPrice;
    private String epubUrl;
    private String pdfUrl;
}
