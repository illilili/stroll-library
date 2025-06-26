package strolllibrary.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import strolllibrary.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/users")
@Transactional
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(
        value = "/usersconsumepoints",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public User consumePoints(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ConsumePointsCommand consumePointsCommand
    ) throws Exception {
        System.out.println("##### /user/consumePoints  called #####");
        User user = new User();
        user.consumePoints(consumePointsCommand);
        userRepository.save(user);
        return user;
    }

    @RequestMapping(
        value = "/usersgrantpoints",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public User grantPoints(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GrantPointsCommand grantPointsCommand
    ) throws Exception {
        System.out.println("##### /user/grantPoints  called #####");
        User user = new User();
        user.grantPoints(grantPointsCommand);
        userRepository.save(user);
        return user;
    }

    @RequestMapping(
        value = "/usersregisteruser",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public User registerUser(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RegisterUserCommand registerUserCommand
    ) throws Exception {
        System.out.println("##### /user/registerUser  called #####");
        User user = new User();
        user.registerUser(registerUserCommand);
        userRepository.save(user);
        return user;
    }
}
//>>> Clean Arch / Inbound Adaptor
