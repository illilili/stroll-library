package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ApproveWriterRegistrationCommand {

    private Long requestId;
    private String reviewedBy;
    private String reviewComment;
}
