package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class PortfolioHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Portfolio>> {

    @Override
    public EntityModel<Portfolio> process(EntityModel<Portfolio> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "createportfolio")
                .withRel("reateportfolio")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/deleteportfolio"
                )
                .withRel("deleteportfolio")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/updateportfolio"
                )
                .withRel("updateportfolio")
        );

        return model;
    }
}
