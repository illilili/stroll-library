package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum SummaryStatus {
    PENDING,
    GENERATING,
    SUCCESS,
    FAILED,
}
