package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class UserHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<User>> {

    @Override
    public EntityModel<User> process(EntityModel<User> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "consumepoints")
                .withRel("onsumepoints")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "grantpoints")
                .withRel("rantpoints")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "registeruser")
                .withRel("egisteruser")
        );

        return model;
    }
}
