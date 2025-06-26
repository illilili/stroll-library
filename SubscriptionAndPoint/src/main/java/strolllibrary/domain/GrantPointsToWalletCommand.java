package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GrantPointsToWalletCommand {

    private String pointWalletId;
    private Integer amount;
    private String reason;
    private Date grantedAt;
}
