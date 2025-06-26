package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdatePublicationMetadataFromCoverCommand {

    private Long publicationMetadataId;
    private CoverImageId coverImageId;
    private String coverImageUrl;
}
