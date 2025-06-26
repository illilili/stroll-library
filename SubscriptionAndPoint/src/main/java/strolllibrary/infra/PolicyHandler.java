package strolllibrary.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import strolllibrary.config.kafka.KafkaProcessor;
import strolllibrary.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PromotionMessageRepository promotionMessageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PointWalletRepository pointWalletRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointExhausted'"
    )
    public void wheneverPointExhausted_DisplayPromotionMessageOnPointExhausted(
        @Payload PointExhausted pointExhausted
    ) {
        PointExhausted event = pointExhausted;
        System.out.println(
            "\n\n##### listener DisplayPromotionMessageOnPointExhausted : " +
            pointExhausted +
            "\n\n"
        );

        // Comments //
        //사용자 포인트가 0 이하가 되는 즉시 유료 구독 또는 KT 요금제 전환 메시지를 노출하여 전환율을 높이고, 사용자 이탈을 방지함

        // Sample Logic //

        DisplayPromotionMessageCommand command = new DisplayPromotionMessageCommand();
        //command.setUserId("???");
        //command.setPromotionType("???");
        //command.setMessage("???");
        //command.setDisplayedAt("???");
        PromotionMessage.displayPromotionMessage(command);
    }
}
//>>> Clean Arch / Inbound Adaptor
