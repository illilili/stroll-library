package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GenerateCategoryAndFeeCommand {

    private String manuscriptId;
    private String summary;
    private String metadata;
    private PublicationRequestId publicationRequestId;
}
