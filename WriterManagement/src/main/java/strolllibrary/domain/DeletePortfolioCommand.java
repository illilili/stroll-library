package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeletePortfolioCommand {

    private Long portfolioId;
}
