package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class CoverImageHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CoverImage>> {

    @Override
    public EntityModel<CoverImage> process(EntityModel<CoverImage> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatecoverimagestatus"
                )
                .withRel("updatecoverimagestatus")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/generatecoverimage"
                )
                .withRel("generatecoverimage")
        );

        return model;
    }
}
