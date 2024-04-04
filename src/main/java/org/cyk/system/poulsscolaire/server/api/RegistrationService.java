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
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link RegistrationDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = RegistrationService.PATH)
@Tag(name = "Gestion des inscriptions")
public interface RegistrationService extends SpecificService {

  String PATH = "inscriptions";

  String CREATE_IDENTIFIER = "CREATION_INSCRIPTION";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une inscription.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une inscription",
      description = "Ce service permet de créer une inscription")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(RegistrationCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {RegistrationCreateRequestDto.FIELD_STUDENT_IDENTIFIER,
      RegistrationCreateRequestDto.FIELD_BRANCH_IDENTIFIER,
      RegistrationCreateRequestDto.FIELD_ASSIGNMNET_TYPE_IDENTIFIER,
      RegistrationCreateRequestDto.FIELD_SENIORITY_IDENTIFIER, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class RegistrationCreateRequestDto extends AbstractAuditedRequestJsonDto {
    @JsonbProperty(JSON_STUDENT_IDENTIFIER)
    private String studentIdentifier;

    @JsonbProperty(JSON_BRANCH_IDENTIFIER)
    private String branchIdentifier;

    @JsonbProperty(JSON_ASSIGNMNET_TYPE_IDENTIFIER)
    private String assignmnetTypeIdentifier;

    @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
    private String seniorityIdentifier;

    public static final String FIELD_STUDENT_IDENTIFIER = "studentIdentifier";
    public static final String FIELD_BRANCH_IDENTIFIER = "branchIdentifier";
    public static final String FIELD_ASSIGNMNET_TYPE_IDENTIFIER = "assignmnetTypeIdentifier";
    public static final String FIELD_SENIORITY_IDENTIFIER = "seniorityIdentifier";

    public static final String JSON_STUDENT_IDENTIFIER = "idEleve";
    public static final String JSON_BRANCH_IDENTIFIER = "idBranche";
    public static final String JSON_ASSIGNMNET_TYPE_IDENTIFIER = "idTypeAffectation";
    public static final String JSON_SENIORITY_IDENTIFIER = "idAnciennete";
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_INSCRIPTION";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des inscriptions")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class GetManyResponseDto extends AbstractGetByPageResponseDto<RegistrationDto> {

    @JsonbProperty(JSON_DATAS)
    private List<RegistrationDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_INSCRIPTION";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une inscription")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_INSCRIPTION";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une inscription")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_INSCRIPTION";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une inscription")
  Response update(RegistrationUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {RegistrationUpdateRequestDto.FIELD_STUDENT_IDENTIFIER,
      RegistrationUpdateRequestDto.FIELD_BRANCH_IDENTIFIER,
      RegistrationUpdateRequestDto.FIELD_ASSIGNMNET_TYPE_IDENTIFIER,
      RegistrationUpdateRequestDto.FIELD_SENIORITY_IDENTIFIER, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class RegistrationUpdateRequestDto extends ByIdentifierRequestDto {
    @JsonbProperty(JSON_STUDENT_IDENTIFIER)
    private String studentIdentifier;

    @JsonbProperty(JSON_BRANCH_IDENTIFIER)
    private String branchIdentifier;

    @JsonbProperty(JSON_ASSIGNMNET_TYPE_IDENTIFIER)
    private String assignmnetTypeIdentifier;

    @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
    private String seniorityIdentifier;

    public static final String FIELD_STUDENT_IDENTIFIER = "studentIdentifier";
    public static final String FIELD_BRANCH_IDENTIFIER = "branchIdentifier";
    public static final String FIELD_ASSIGNMNET_TYPE_IDENTIFIER = "assignmnetTypeIdentifier";
    public static final String FIELD_SENIORITY_IDENTIFIER = "seniorityIdentifier";

    public static final String JSON_STUDENT_IDENTIFIER = "idEleve";
    public static final String JSON_BRANCH_IDENTIFIER = "idBranche";
    public static final String JSON_ASSIGNMNET_TYPE_IDENTIFIER = "idTypeAffectation";
    public static final String JSON_SENIORITY_IDENTIFIER = "idAnciennete";
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_INSCRIPTION";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une inscription")
  Response delete(DeleteOneRequestDto request);
}
