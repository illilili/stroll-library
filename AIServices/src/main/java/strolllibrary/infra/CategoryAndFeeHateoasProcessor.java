package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class CategoryAndFeeHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CategoryAndFee>> {

    @Override
    public EntityModel<CategoryAndFee> process(
        EntityModel<CategoryAndFee> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "generatecategoryandfee"
                )
                .withRel("eneratecategoryandfee")
        );

        return model;
    }
}
