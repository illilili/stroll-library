package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class PromotionMessageHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PromotionMessage>> {

    @Override
    public EntityModel<PromotionMessage> process(
        EntityModel<PromotionMessage> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "displaypromotionmessage"
                )
                .withRel("isplaypromotionmessage")
        );

        return model;
    }
}
