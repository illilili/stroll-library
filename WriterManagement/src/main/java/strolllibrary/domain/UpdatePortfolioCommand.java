package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdatePortfolioCommand {

    private Long portfolioId;
    private String portfolioUrl;
    private Date updatedAt;
}
