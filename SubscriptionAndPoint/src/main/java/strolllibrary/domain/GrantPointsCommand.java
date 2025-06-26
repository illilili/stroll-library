package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GrantPointsCommand {

    private String userId;
    private Integer amount;
    private String reason;
    private Date grantedAt;
}
