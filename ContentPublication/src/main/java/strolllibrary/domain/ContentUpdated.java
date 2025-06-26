package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ContentUpdated extends AbstractEvent {

    private Long contentId;
    private Long writerId;
    private String title;
    private String body;
    private String keywords;
    private ContentSaveStatus saveStatus;
    private Date updatedAt;

    public ContentUpdated(Content aggregate) {
        super(aggregate);
    }

    public ContentUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
