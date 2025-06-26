package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ContentFinalListQuery {

    private Long writerId;
    private ContentSaveStatus saveStatus;
    private Date createdAt;
}
