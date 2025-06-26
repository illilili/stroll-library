package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class BadgeHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Badge>> {

    @Override
    public EntityModel<Badge> process(EntityModel<Badge> model) {
        return model;
    }
}
