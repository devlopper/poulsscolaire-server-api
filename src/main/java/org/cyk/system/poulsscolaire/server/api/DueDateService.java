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
 * Cette interface représente les services de {@link DueDateDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = DueDateService.PATH)
@Tag(name = "Gestion des dates d'échéances")
public interface DueDateService extends SpecificService {

  String PATH = "dates-echeance";

  String CREATE_IDENTIFIER = "CREATION_DATE_ECHEANCE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une date d'échéance.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une date d'échéance",
      description = "Ce service permet de créer une date d'échéance")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(DueDateCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(
      value = {DueDateCreateRequestDto.FIELD_GROUP_IDENTIFIER, DueDateCreateRequestDto.FIELD_DATE,
          AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class DueDateCreateRequestDto extends AbstractAuditedRequestJsonDto {
    @JsonbProperty(JSON_GROUP_IDENTIFIER)
    private String groupIdentifier;

    @JsonbProperty(JSON_DATE)
    private LocalDateTime date;

    public static final String FIELD_GROUP_IDENTIFIER = "groupIdentifier";
    public static final String FIELD_DATE = "date";

    public static final String JSON_GROUP_IDENTIFIER = "idGroupe";
    public static final String JSON_DATE = "date";
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_DATE_ECHEANCE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des dates d'échéance")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class GetManyResponseDto extends AbstractGetByPageResponseDto<DueDateDto> {

    @JsonbProperty(JSON_DATAS)
    private List<DueDateDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_DATE_ECHEANCE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une date d'échéance")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_DATE_ECHEANCE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une date d'échéance")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_DATE_ECHEANCE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une date d'échéance")
  Response update(DueDateUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {ByIdentifierRequestDto.FIELD_IDENTIFIER,
      DueDateUpdateRequestDto.FIELD_GROUP_IDENTIFIER, DueDateUpdateRequestDto.FIELD_DATE,
      AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class DueDateUpdateRequestDto extends ByIdentifierRequestDto {
    @JsonbProperty(JSON_GROUP_IDENTIFIER)
    private String groupIdentifier;

    @JsonbProperty(JSON_DATE)
    private LocalDateTime date;

    public static final String FIELD_GROUP_IDENTIFIER = "groupIdentifier";
    public static final String FIELD_DATE = "date";

    public static final String JSON_GROUP_IDENTIFIER = "idGroupe";
    public static final String JSON_DATE = "date";
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_DATE_ECHEANCE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une date d'échéance")
  Response delete(DeleteOneRequestDto request);
}
