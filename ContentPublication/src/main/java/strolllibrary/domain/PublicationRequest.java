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

@Entity
@Table(name = "PublicationRequest_table")
@Data
//<<< DDD / Aggregate Root
public class PublicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publicationRequestId;

    private Long contentId;

    private Date requestDate;

    private PublicationRequestStatus status;

    private String coverImageUrl;

    private String summary;

    private String category;

    private Double subscriptionPrice;

    private String epubUrl;

    private String pdfUrl;

    public static PublicationRequestRepository repository() {
        PublicationRequestRepository publicationRequestRepository = ContentPublicationApplication.applicationContext.getBean(
            PublicationRequestRepository.class
        );
        return publicationRequestRepository;
    }

    //<<< Clean Arch / Port Method
    public void updatePublicationRequestMetadata(
        UpdatePublicationRequestMetadataCommand updatePublicationRequestMetadataCommand
    ) {
        //implement business logic here:

        PublicationRequestMetadataUpdated publicationRequestMetadataUpdated = new PublicationRequestMetadataUpdated(
            this
        );
        publicationRequestMetadataUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
