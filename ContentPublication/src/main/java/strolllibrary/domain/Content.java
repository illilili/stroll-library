package strolllibrary.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import strolllibrary.ContentPublicationApplication;
import strolllibrary.domain.ContentDrafted;
import strolllibrary.domain.ContentSaved;
import strolllibrary.domain.ContentUpdated;

@Entity
@Table(name = "Content_table")
@Data
//<<< DDD / Aggregate Root
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contentId;

    private Long writerId;

    private String title;

    private String summary;

    private String keywords;

    private String body;

    private ContentSaveStatus saveStatus;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private WriterProfileId writerProfileId;

    @PostPersist
    public void onPostPersist() {
        ContentUpdated contentUpdated = new ContentUpdated(this);
        contentUpdated.publishAfterCommit();

        ContentDrafted contentDrafted = new ContentDrafted(this);
        contentDrafted.publishAfterCommit();

        ContentSaved contentSaved = new ContentSaved(this);
        contentSaved.publishAfterCommit();
    }

    public static ContentRepository repository() {
        ContentRepository contentRepository = ContentPublicationApplication.applicationContext.getBean(
            ContentRepository.class
        );
        return contentRepository;
    }

    //<<< Clean Arch / Port Method
    public void draftContent(DraftContentCommand draftContentCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateContent(UpdateContentCommand updateContentCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void saveContent(SaveContentCommand saveContentCommand) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
