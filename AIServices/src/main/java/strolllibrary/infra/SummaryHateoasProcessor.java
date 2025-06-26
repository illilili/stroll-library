package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class SummaryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Summary>> {

    @Override
    public EntityModel<Summary> process(EntityModel<Summary> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatesummarystatus"
                )
                .withRel("updatesummarystatus")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "generatesummary")
                .withRel("eneratesummary")
        );

        return model;
    }
}
