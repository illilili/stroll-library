package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PublicationRequestHistoryQuery {

    private Long contentId;
    private Date requestedAt;
}
