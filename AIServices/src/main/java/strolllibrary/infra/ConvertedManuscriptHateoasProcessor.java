package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class ConvertedManuscriptHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ConvertedManuscript>> {

    @Override
    public EntityModel<ConvertedManuscript> process(
        EntityModel<ConvertedManuscript> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "convertmanuscript"
                )
                .withRel("onvertmanuscript")
        );

        return model;
    }
}
