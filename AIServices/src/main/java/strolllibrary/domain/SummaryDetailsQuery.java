package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class SummaryDetailsQuery {

    private String summaryId;
    private String manuscriptId;
    private SummaryStatus status;
}
