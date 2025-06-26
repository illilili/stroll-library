package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdatePublicationMetadataFromConversionCommand {

    private Long publicationMetadataId;
    private ConvertedManuscriptId convertedManuscriptId;
    private String epubUrl;
    private String pdfUrl;
}
