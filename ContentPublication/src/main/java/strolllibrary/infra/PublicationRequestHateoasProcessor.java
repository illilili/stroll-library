package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class PublicationRequestHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PublicationRequest>> {

    @Override
    public EntityModel<PublicationRequest> process(
        EntityModel<PublicationRequest> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatepublicationrequestmetadata"
                )
                .withRel("updatepublicationrequestmetadata")
        );

        return model;
    }
}
