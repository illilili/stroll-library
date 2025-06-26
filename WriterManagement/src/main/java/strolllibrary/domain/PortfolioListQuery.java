package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PortfolioListQuery {

    private Long writerId;
    private Date createdAt;
}
