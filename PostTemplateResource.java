package com.pelikantravel.discountTemplates.resource;

import com.pelikantravel.common.resource.EntityMongoResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.shared.discountTemplate.PostTemplate;
import utils.shared.discountTemplate.PostTemplateService;
import utils.shared.discountTemplate.TemplateData;
import utils.shared.discountTemplate.TemplateDefinitionDTO;
import utils.shared.discountedOffer.DiscountedOffer;
import utils.shared.postTemplates.provider.PostTemplateStrategy;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Marek Tomas on 21.1.2020
 */
@Stateless
@Produces("application/json")
@Path("post-templates")
public class PostTemplateResource extends EntityMongoResource<PostTemplate> {

    private static final Logger log = LoggerFactory.getLogger(PostTemplateResource.class);

    public PostTemplateResource() {
        super(PostTemplate.class);
    }

    @Inject
    private PostTemplateService postTemplateService;

    @Override
    public PostTemplate create(@Valid PostTemplate entity) {
        return super.create(entity);
    }

    @GET
    @Path("/templates-definition-names")
    public List<TemplateDefinitionDTO> getPostTemplateDefinitionsNames() {
        return postTemplateService.getPostTemplateDefinitionsNames();
    }

    @POST
    @Path("/import-data/{templateId}")
    public Response importValue(@PathParam("templateId") String templateId, TemplateData data) {
        return postTemplateService.importData(data) == null ?
                Response.ok(Response.Status.BAD_REQUEST).build() : Response.ok(Response.Status.OK).build();
    }

    @POST
    @Path("/insert-discount-offer")
    public PostTemplate insertOffer(DiscountedOffer offer) {
        return postTemplateService.executeProvider("sk", PostTemplateStrategy.RANDOM, offer);
    }

    @GET
    @Path("/find-active")
    public PostTemplate findActive() {
        return getRepository().getCollection().findOne("{active: #}", Boolean.TRUE).as(PostTemplate.class);
    }
}
