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
import strolllibrary.domain.CategoryAndFeeGenerated;
import strolllibrary.domain.CategoryAndFeeGenerationFailed;

@Entity
@Table(name = "CategoryAndFee_table")
@Data
//<<< DDD / Aggregate Root
public class CategoryAndFee {

    @Id
    private String categoryAndFeeId;

    private String manuscriptId;

    private String bookId;

    private String category;

    private Double feeAmount;

    private String currency;

    private CategoryFeeStatus status;

    private Date generatedAt;

    @Embedded
    private PublicationRequestId publicationRequestId;

    @PostPersist
    public void onPostPersist() {
        CategoryAndFeeGenerationFailed categoryAndFeeGenerationFailed = new CategoryAndFeeGenerationFailed(
            this
        );
        categoryAndFeeGenerationFailed.publishAfterCommit();

        CategoryAndFeeGenerated categoryAndFeeGenerated = new CategoryAndFeeGenerated(
            this
        );
        categoryAndFeeGenerated.publishAfterCommit();
    }

    public static CategoryAndFeeRepository repository() {
        CategoryAndFeeRepository categoryAndFeeRepository = AiServicesApplication.applicationContext.getBean(
            CategoryAndFeeRepository.class
        );
        return categoryAndFeeRepository;
    }

    //<<< Clean Arch / Port Method
    public void generateCategoryAndFee(
        GenerateCategoryAndFeeCommand generateCategoryAndFeeCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
