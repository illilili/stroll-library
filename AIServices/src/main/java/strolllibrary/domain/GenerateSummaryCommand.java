package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GenerateSummaryCommand {

    private String manuscriptId;
    private String content;
    private PublicationRequestId publicationRequestId;
}
