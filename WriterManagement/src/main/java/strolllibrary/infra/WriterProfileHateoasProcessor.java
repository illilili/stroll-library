package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class WriterProfileHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<WriterProfile>> {

    @Override
    public EntityModel<WriterProfile> process(
        EntityModel<WriterProfile> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "requestwriterregistration"
                )
                .withRel("equestwriterregistration")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/approvewriterregistration"
                )
                .withRel("approvewriterregistration")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/rejectwriterregistration"
                )
                .withRel("rejectwriterregistration")
        );

        return model;
    }
}
