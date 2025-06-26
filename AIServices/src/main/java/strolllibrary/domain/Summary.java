package strolllibrary.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import strolllibrary.AiServicesApplication;

@Entity
@Table(name = "Summary_table")
@Data
//<<< DDD / Aggregate Root
public class Summary {

    @Id
    private String summaryId;

    private String manuscriptId;

    private String content;

    private SummaryStatus status;

    @Embedded
    private PublicationRequestId publicationRequestId;

    public static SummaryRepository repository() {
        SummaryRepository summaryRepository = AiServicesApplication.applicationContext.getBean(
            SummaryRepository.class
        );
        return summaryRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateSummaryStatus(
        UpdateSummaryStatusCommand updateSummaryStatusCommand
    ) {
        //implement business logic here:

        SummaryStatusUpdated summaryStatusUpdated = new SummaryStatusUpdated(
            this
        );
        summaryStatusUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void generateSummary(GenerateSummaryCommand generateSummaryCommand) {
        //implement business logic here:

        SummaryGenerationFailed summaryGenerationFailed = new SummaryGenerationFailed(
            this
        );
        summaryGenerationFailed.publishAfterCommit();
        SummaryGenerated summaryGenerated = new SummaryGenerated(this);
        summaryGenerated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
