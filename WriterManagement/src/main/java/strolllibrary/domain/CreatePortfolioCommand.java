package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreatePortfolioCommand {

    private Long writerId;
    private String portfolioUrl;
    private Date createdAt;
}
