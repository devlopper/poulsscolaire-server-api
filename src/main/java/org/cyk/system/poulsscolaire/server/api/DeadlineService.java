package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractGetByPageResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link DeadlineDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = DeadlineService.PATH)
@Tag(name = "Gestion des échéances")
public interface DeadlineService extends SpecificService {

  String PATH = "echeances";

  String CREATE_IDENTIFIER = "CREATION_ECHEANCE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une échéance.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une échéance",
      description = "Ce service permet de créer une échéance")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(DeadlineCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(
      value = {DeadlineCreateRequestDto.FIELD_GROUP_IDENTIFIER, DeadlineCreateRequestDto.FIELD_DATE,
          AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class DeadlineCreateRequestDto extends AbstractAuditedRequestJsonDto {
    @JsonbProperty(JSON_GROUP_IDENTIFIER)
    private String groupIdentifier;

    @JsonbProperty(JSON_DATE)
    private LocalDateTime date;

    public static final String FIELD_GROUP_IDENTIFIER = "groupIdentifier";
    public static final String FIELD_DATE = "date";

    public static final String JSON_GROUP_IDENTIFIER = "idGroupe";
    public static final String JSON_DATE = "date";
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_ECHEANCE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des échéances")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class GetManyResponseDto extends AbstractGetByPageResponseDto<DeadlineDto> {

    @JsonbProperty(JSON_DATAS)
    private List<DeadlineDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_ECHEANCE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une échéance")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_ECHEANCE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une échéance")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_ECHEANCE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une échéance")
  Response update(DeadlineUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {ByIdentifierRequestDto.FIELD_IDENTIFIER,
      DeadlineUpdateRequestDto.FIELD_GROUP_IDENTIFIER, DeadlineUpdateRequestDto.FIELD_DATE,
      AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class DeadlineUpdateRequestDto extends ByIdentifierRequestDto {
    @JsonbProperty(JSON_GROUP_IDENTIFIER)
    private String groupIdentifier;

    @JsonbProperty(JSON_DATE)
    private LocalDateTime date;

    public static final String FIELD_GROUP_IDENTIFIER = "groupIdentifier";
    public static final String FIELD_DATE = "date";

    public static final String JSON_GROUP_IDENTIFIER = "idGroupe";
    public static final String JSON_DATE = "date";
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_ECHEANCE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une échéance")
  Response delete(DeleteOneRequestDto request);
}
