package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractGetByPageResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractResponseDto;
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
 * Cette interface représente les services de {@link SchoolingDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = SchoolingService.PATH)
@Tag(name = "Gestion des scolarités")
public interface SchoolingService extends SpecificService {

  String PATH = "scolarites";

  String CREATE_IDENTIFIER = "CREATION_SCOLARITE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une scolarité.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une scolarité",
      description = "Ce service permet de créer une scolarité")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(SchoolingCreateRequestDto request);

  /**
   * Cette classe représente la requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface SaveRequestDto {
    String getSchoolIdentifier();

    void setSchoolIdentifier(String schoolIdentifier);

    String getBranchIdentifier();

    void setBranchIdentifier(String branchIdentifier);

    String getPeriodIdentifier();

    void setPeriodIdentifier(String periodIdentifier);

    int getPreRegistrationAmount();

    void setPreRegistrationAmount(int preRegistrationAmount);

    String JSON_SCHOOL_IDENTIFIER = "idEcole";
    String JSON_BRANCH_IDENTIFIER = "idBranche";
    String JSON_PERIOD_IDENTIFIER = "idPeriod";
    String JSON_PRE_REGISTRATION_AMOUNT = "montantPreInscription";
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SchoolingCreateRequestDto extends AbstractAuditedRequestJsonDto implements SaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_BRANCH_IDENTIFIER)
    private String branchIdentifier;

    @JsonbProperty(JSON_PERIOD_IDENTIFIER)
    private String periodIdentifier;

    @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT)
    private int preRegistrationAmount;
  }

  String GENERATE_IDENTIFIER = "GENERATION_SCOLARITE";

  String GENERATE_PATH = "generation";

  @Path(GENERATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = GENERATE_IDENTIFIER,
      description = "Ce service permet de générer les scolarités")
  Response generate(SchoolingGenerateRequestDto request);

  /**
   * Cette classe représente la requête de génération.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class SchoolingGenerateRequestDto extends AbstractAuditedRequestJsonDto {

  }

  /**
   * Cette classe représente la réponse de génération.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class SchoolingGenerateResponseDto extends AbstractResponseDto {
    @JsonbProperty("nombre")
    int count;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_SCOLARITE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des scolarités")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class SchoolingGetManyResponseDto
      extends AbstractGetByPageResponseDto<SchoolingDto> {

    @JsonbProperty(JSON_DATAS)
    private List<SchoolingDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_SCOLARITE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une scolarité")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_SCOLARITE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une scolarité")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_SCOLARITE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une scolarité")
  Response update(SchoolingUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SchoolingUpdateRequestDto extends ByIdentifierRequestDto implements SaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_BRANCH_IDENTIFIER)
    private String branchIdentifier;

    @JsonbProperty(JSON_PERIOD_IDENTIFIER)
    private String periodIdentifier;

    @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT)
    private int preRegistrationAmount;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_SCOLARITE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une scolarité")
  Response delete(DeleteOneRequestDto request);
}
