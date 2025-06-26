package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterUserCommand {

    private String userId;
    private String name;
    private Boolean ktCustomer;
}
