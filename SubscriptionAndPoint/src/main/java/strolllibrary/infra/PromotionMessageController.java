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
// @RequestMapping(value="/promotionMessages")
@Transactional
public class PromotionMessageController {

    @Autowired
    PromotionMessageRepository promotionMessageRepository;

    @RequestMapping(
        value = "/promotionMessagesdisplaypromotionmessage",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PromotionMessage displayPromotionMessage(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody DisplayPromotionMessageCommand displayPromotionMessageCommand
    ) throws Exception {
        System.out.println(
            "##### /promotionMessage/displayPromotionMessage  called #####"
        );
        PromotionMessage promotionMessage = new PromotionMessage();
        promotionMessage.displayPromotionMessage(
            displayPromotionMessageCommand
        );
        promotionMessageRepository.save(promotionMessage);
        return promotionMessage;
    }
}
//>>> Clean Arch / Inbound Adaptor
