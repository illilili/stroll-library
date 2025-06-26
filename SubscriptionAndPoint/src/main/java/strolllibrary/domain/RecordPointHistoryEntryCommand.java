package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RecordPointHistoryEntryCommand {

    private String pointWalletId;
    private Date changeDate;
    private Integer changeAmount;
    private String description;
    private Integer balanceAfterChange;
}
