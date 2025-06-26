package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DisplayPromotionMessageCommand {

    private UserId userId;
    private PromotionType promotionType;
    private String message;
    private Date displayedAt;
}
