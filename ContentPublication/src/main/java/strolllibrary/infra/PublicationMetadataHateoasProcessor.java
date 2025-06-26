package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class PublicationMetadataHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PublicationMetadata>> {

    @Override
    public EntityModel<PublicationMetadata> process(
        EntityModel<PublicationMetadata> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatepublicationmetadatafromconversion"
                )
                .withRel("updatepublicationmetadatafromconversion")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatepublicationmetadatafromsummary"
                )
                .withRel("updatepublicationmetadatafromsummary")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatepublicationmetadatafromcategoryandpricing"
                )
                .withRel("updatepublicationmetadatafromcategoryandpricing")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatepublicationmetadatafromcover"
                )
                .withRel("updatepublicationmetadatafromcover")
        );

        return model;
    }
}
