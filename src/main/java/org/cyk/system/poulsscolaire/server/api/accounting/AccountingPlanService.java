package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableNamableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableNamableUpdateRequestJsonDto;
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
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link AccountingPlanDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AccountingPlanService.PATH)
@Tag(name = "Gestion des plans comptables")
public interface AccountingPlanService extends SpecificService {

  String PATH = "plans-comptables";

  String CREATE_IDENTIFIER = "CREATION_PLAN_COMPTABLE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un plan comptable",
      description = "Ce service permet de créer un plan comptable")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AccountingPlanCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface AccountingPlanSaveRequestDto {
    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link SchoolDto}.
     *
     * @return identifiant de {@link SchoolDto}
     */
    String getSchoolIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link SchoolDto}.
     *
     * @param schoolIdentifier identifiant de {@link SchoolDto}
     */
    void setSchoolIdentifier(String schoolIdentifier);

    String JSON_SCHOOL_IDENTIFIER = AccountingPlanDto.JSON_SCHOOL_IDENTIFIER;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingPlanCreateRequestDto extends AbstractCodableNamableCreateRequestJsonDto
      implements AccountingPlanSaveRequestDto {

    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_PLAN_COMPTABLE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des caisses enregistreuses")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class AccountingPlanGetManyResponseDto
      extends AbstractGetByPageResponseDto<AccountingPlanDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AccountingPlanDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_PLAN_COMPTABLE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir un plan comptable")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_PLAN_COMPTABLE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un plan comptable")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_PLAN_COMPTABLE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un plan comptable")
  Response update(AccountingPlanUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingPlanUpdateRequestDto extends AbstractCodableNamableUpdateRequestJsonDto
      implements AccountingPlanSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_PLAN_COMPTABLE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un plan comptable")
  Response delete(DeleteOneRequestDto request);
}
