package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ContentDrafted extends AbstractEvent {

    private Long contentId;
    private Long writerId;
    private String title;
    private String body;
    private String keywords;
    private ContentSaveStatus saveStatus;
    private Date createdAt;

    public ContentDrafted(Content aggregate) {
        super(aggregate);
    }

    public ContentDrafted() {
        super();
    }
}
//>>> DDD / Domain Event
