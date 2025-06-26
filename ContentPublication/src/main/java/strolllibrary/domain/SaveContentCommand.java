package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SaveContentCommand {

    private Long writerId;
    private String title;
    private String body;
    private String keywords;
}
