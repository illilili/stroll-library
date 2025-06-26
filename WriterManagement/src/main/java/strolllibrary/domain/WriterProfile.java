package strolllibrary.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import strolllibrary.WriterManagementApplication;
import strolllibrary.domain.WriterRegistrationApproved;
import strolllibrary.domain.WriterRegistrationRejected;
import strolllibrary.domain.WriterRegistrationRequested;

@Entity
@Table(name = "WriterProfile_table")
@Data
//<<< DDD / Aggregate Root
public class WriterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestId;

    private String writerName;

    private String email;

    private String introduction;

    private String portfolioUrl;

    private WriterRegistrationStatus status;

    private Date submittedAt;

    private Date reviewedAt;

    private String reviewedBy;

    private String reviewComment;

    @Embedded
    private ContentId contentId;

    @Embedded
    private PortfolioId portfolioId;

    @PostPersist
    public void onPostPersist() {
        WriterRegistrationRejected writerRegistrationRejected = new WriterRegistrationRejected(
            this
        );
        writerRegistrationRejected.publishAfterCommit();

        WriterRegistrationApproved writerRegistrationApproved = new WriterRegistrationApproved(
            this
        );
        writerRegistrationApproved.publishAfterCommit();

        WriterRegistrationRequested writerRegistrationRequested = new WriterRegistrationRequested(
            this
        );
        writerRegistrationRequested.publishAfterCommit();
    }

    public static WriterProfileRepository repository() {
        WriterProfileRepository writerProfileRepository = WriterManagementApplication.applicationContext.getBean(
            WriterProfileRepository.class
        );
        return writerProfileRepository;
    }

    //<<< Clean Arch / Port Method
    public void requestWriterRegistration(
        RequestWriterRegistrationCommand requestWriterRegistrationCommand
    ) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void approveWriterRegistration(
        ApproveWriterRegistrationCommand approveWriterRegistrationCommand
    ) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void rejectWriterRegistration(
        RejectWriterRegistrationCommand rejectWriterRegistrationCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
