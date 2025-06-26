package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class BookHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Book>> {

    @Override
    public EntityModel<Book> process(EntityModel<Book> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/grantbestsellerbadge"
                )
                .withRel("grantbestsellerbadge")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deletebook")
                .withRel("deletebook")
        );

        return model;
    }
}
