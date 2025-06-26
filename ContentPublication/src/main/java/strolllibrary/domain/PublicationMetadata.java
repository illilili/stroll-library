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
@Table(name = "PublicationMetadata_table")
@Data
//<<< DDD / Aggregate Root
public class PublicationMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publicationMetadataId;

    private Long contentId;

    private String coverImageUrl;

    private String summary;

    private String category;

    private Double subscriptionPrice;

    private String epubUrl;

    private String pdfUrl;

    private PublicationStatus status;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private CoverImageId coverImageId;

    @Embedded
    private SummaryId summaryId;

    @Embedded
    private ConvertedManuscriptId convertedManuscriptId;

    @Embedded
    private CategoryAndFeeId categoryAndFeeId;

    public static PublicationMetadataRepository repository() {
        PublicationMetadataRepository publicationMetadataRepository = ContentPublicationApplication.applicationContext.getBean(
            PublicationMetadataRepository.class
        );
        return publicationMetadataRepository;
    }

    //<<< Clean Arch / Port Method
    public void updatePublicationMetadataFromConversion(
        UpdatePublicationMetadataFromConversionCommand updatePublicationMetadataFromConversionCommand
    ) {
        //implement business logic here:

        ConversionUpdate conversionUpdate = new ConversionUpdate(this);
        conversionUpdate.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updatePublicationMetadataFromSummary(
        UpdatePublicationMetadataFromSummaryCommand updatePublicationMetadataFromSummaryCommand
    ) {
        //implement business logic here:

        SummaryUpdate summaryUpdate = new SummaryUpdate(this);
        summaryUpdate.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updatePublicationMetadataFromCategoryAndPricing(
        UpdatePublicationMetadataFromCategoryAndPricingCommand updatePublicationMetadataFromCategoryAndPricingCommand
    ) {
        //implement business logic here:

        CategoryAndPricingGenerated categoryAndPricingGenerated = new CategoryAndPricingGenerated(
            this
        );
        categoryAndPricingGenerated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updatePublicationMetadataFromCover(
        UpdatePublicationMetadataFromCoverCommand updatePublicationMetadataFromCoverCommand
    ) {
        //implement business logic here:

        CoverUpdated coverUpdated = new CoverUpdated(this);
        coverUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
