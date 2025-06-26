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
import strolllibrary.domain.CoverImageGenerated;
import strolllibrary.domain.CoverImageGenerationFailed;
import strolllibrary.domain.CoverImageStatusUpdated;

@Entity
@Table(name = "CoverImage_table")
@Data
//<<< DDD / Aggregate Root
public class CoverImage {

    @Id
    private String coverImageId;

    private String manuscriptId;

    private String imageUrl;

    private CoverImageStatus status;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private PublicationRequestId publicationRequestId;

    @PostPersist
    public void onPostPersist() {
        CoverImageGenerated coverImageGenerated = new CoverImageGenerated(this);
        coverImageGenerated.publishAfterCommit();

        CoverImageGenerationFailed coverImageGenerationFailed = new CoverImageGenerationFailed(
            this
        );
        coverImageGenerationFailed.publishAfterCommit();

        CoverImageStatusUpdated coverImageStatusUpdated = new CoverImageStatusUpdated(
            this
        );
        coverImageStatusUpdated.publishAfterCommit();
    }

    public static CoverImageRepository repository() {
        CoverImageRepository coverImageRepository = AiServicesApplication.applicationContext.getBean(
            CoverImageRepository.class
        );
        return coverImageRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateCoverImageStatus(
        UpdateCoverImageStatusCommand updateCoverImageStatusCommand
    ) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void generateCoverImage(
        GenerateCoverImageCommand generateCoverImageCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
