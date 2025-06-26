package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PromotionMessageHistoryQuery {

    private UserId userId;
    private PromotionType promotionType;
    private Date displayedAt;
}
