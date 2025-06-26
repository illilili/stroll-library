package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GenerateCoverImageCommand {

    private String manuscriptId;
    private String title;
    private String summary;
    private String keywords;
    private PublicationRequestId publicationRequestId;
}
