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

@Entity
@Table(name = "Portfolio_table")
@Data
//<<< DDD / Aggregate Root
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long portfolioId;

    private Long writerId;

    private String portfolioUrl;

    private Date createdAt;

    public static PortfolioRepository repository() {
        PortfolioRepository portfolioRepository = WriterManagementApplication.applicationContext.getBean(
            PortfolioRepository.class
        );
        return portfolioRepository;
    }

    //<<< Clean Arch / Port Method
    public void createPortfolio(CreatePortfolioCommand createPortfolioCommand) {
        //implement business logic here:

        PortfolioCreated portfolioCreated = new PortfolioCreated(this);
        portfolioCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deletePortfolio(DeletePortfolioCommand deletePortfolioCommand) {
        //implement business logic here:

        PortfolioDeleted portfolioDeleted = new PortfolioDeleted(this);
        portfolioDeleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updatePortfolio(UpdatePortfolioCommand updatePortfolioCommand) {
        //implement business logic here:

        PortfolioUpdated portfolioUpdated = new PortfolioUpdated(this);
        portfolioUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
