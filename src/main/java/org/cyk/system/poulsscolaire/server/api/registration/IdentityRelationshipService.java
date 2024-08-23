package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractGetByPageResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link IdentityRelationshipDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = IdentityService.PATH)
@Tag(name = "Gestion des relations père fils entre deux identités")
public interface IdentityRelationshipService extends SpecificService {

  String PATH = "relations-identites";

  String CREATE_IDENTIFIER = "CREATION_RELATION_IDENTITE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une relation d'identité.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une relation d'identité",
      description = "Ce service permet de créer une relation d'identité")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(IdentityRelationshipCreateRequestDto request);

  /**
   * Cette interface représente une reuqête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface IdentityRelationshipSaveRequest {
    String getParentIdentifier();

    void setParentIdentifier(String parentIdentifier);

    String getChildIdentifier();

    void setChildIdentifier(String childIdentifier);

    IdentityRelationshipType getType();

    void setType(IdentityRelationshipType type);

    String JSON_PARENT_IDENTIFIER = IdentityRelationshipDto.JSON_PARENT_IDENTIFIER;
    String JSON_CHILD_IDENTIFIER = IdentityRelationshipDto.JSON_CHILD_IDENTIFIER;
    String JSON_TYPE = IdentityRelationshipDto.JSON_TYPE;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class IdentityRelationshipCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements IdentityRelationshipSaveRequest {
    @JsonbProperty(JSON_PARENT_IDENTIFIER)
    private String parentIdentifier;

    @JsonbProperty(JSON_CHILD_IDENTIFIER)
    private String childIdentifier;

    @JsonbProperty(JSON_TYPE)
    private IdentityRelationshipType type;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_RELATION_IDENTITE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des relations d'identités")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class IdentityRelationshipGetManyResponseDto
      extends AbstractGetByPageResponseDto<IdentityRelationshipDto> {

    @JsonbProperty(JSON_DATAS)
    private List<IdentityRelationshipDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_RELATION_IDENTITE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une relation d'identité")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_RELATION_IDENTITE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une relation d'identité")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_RELATION_IDENTITE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une relation d'identité")
  Response update(IdentityRelationshipUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class IdentityRelationshipUpdateRequestDto extends ByIdentifierRequestDto
      implements IdentityRelationshipSaveRequest {
    @JsonbProperty(JSON_PARENT_IDENTIFIER)
    private String parentIdentifier;

    @JsonbProperty(JSON_CHILD_IDENTIFIER)
    private String childIdentifier;

    @JsonbProperty(JSON_TYPE)
    private IdentityRelationshipType type;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_RELATION_IDENTITE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une relation d'identité")
  Response delete(DeleteOneRequestDto request);
}
