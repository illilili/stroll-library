package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ContentSaved extends AbstractEvent {

    private Long contentId;
    private Long writerId;
    private String title;
    private String body;
    private String keywords;
    private ContentSaveStatus saveStatus;
    private Date createdAt;

    public ContentSaved(Content aggregate) {
        super(aggregate);
    }

    public ContentSaved() {
        super();
    }
}
//>>> DDD / Domain Event
