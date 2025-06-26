package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestWriterRegistrationCommand {

    private String writerName;
    private String email;
    private String introduction;
    private String portfolioUrl;
}
