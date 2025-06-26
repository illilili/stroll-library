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
@Table(name = "ConvertedManuscript_table")
@Data
//<<< DDD / Aggregate Root
public class ConvertedManuscript {

    @Id
    private String convertedManuscriptId;

    private String manuscriptId;

    private String epubUrl;

    private String pdfUrl;

    private ManuscriptConvertStatus status;

    private Date convertedAt;

    @Embedded
    private PublicationRequestId publicationRequestId;

    public static ConvertedManuscriptRepository repository() {
        ConvertedManuscriptRepository convertedManuscriptRepository = AiServicesApplication.applicationContext.getBean(
            ConvertedManuscriptRepository.class
        );
        return convertedManuscriptRepository;
    }

    //<<< Clean Arch / Port Method
    public void convertManuscript(
        ConvertManuscriptCommand convertManuscriptCommand
    ) {
        //implement business logic here:

        ManuscriptConversionFailed manuscriptConversionFailed = new ManuscriptConversionFailed(
            this
        );
        manuscriptConversionFailed.publishAfterCommit();
        ManuscriptConverted manuscriptConverted = new ManuscriptConverted(this);
        manuscriptConverted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
