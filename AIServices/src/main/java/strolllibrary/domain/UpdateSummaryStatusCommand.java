package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateSummaryStatusCommand {

    private String summaryId;
    private SummaryStatus status;
    private Date updatedAt;
    private String failureReason;
}
