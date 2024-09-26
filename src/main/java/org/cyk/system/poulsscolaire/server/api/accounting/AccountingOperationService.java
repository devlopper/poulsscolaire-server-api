package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractNamableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractNamableUpdateRequestJsonDto;
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
 * Cette interface représente les services de {@link AccountingOperationDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AccountingOperationService.PATH)
@Tag(name = "Gestion des opérations comptables")
public interface AccountingOperationService extends SpecificService {

  String PATH = "operations-comptables";

  String CREATE_IDENTIFIER = "CREATION_OPERATION_COMPTABLE";

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
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une opération comptable",
      description = "Ce service permet de créer une opération comptable")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AccountingOperationCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface AccountingOperationSaveRequestDto {
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

    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link AccountingPlanDto}.
     *
     * @return identifiant de {@link AccountingPlanDto}
     */
    String getPlanIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link AccountingPlanDto}.
     *
     * @param planIdentifier identifiant de {@link AccountingPlanDto}
     */
    void setPlanIdentifier(String planIdentifier);
    
    /**
     * Cette méthode permet d'obtenir {@link AccountingAccountType}.
     *
     * @return {@link AccountingAccountType}
     */
    AccountingAccountType getAccountType();

    /**
     * Cette méthode permet d'assigner {@link AccountingAccountType}.
     *
     * @param accountType {@link AccountingAccountType}
     */
    void setAccountType(AccountingAccountType accountType);

    /**
     * Cette méthode permet d'obtenir le bénéficiaire.
     *
     * @return bénéficiaire
     */
    String getBeneficiary();

    /**
     * Cette méthode permet d'assigner le bénéficiaire.
     *
     * @param beneficiary bénéficiaire
     */
    void setBeneficiary(String beneficiary);

    String JSON_SCHOOL_IDENTIFIER = AccountingOperationDto.JSON_SCHOOL_IDENTIFIER;
    
    String JSON_PLAN_IDENTIFIER = AccountingOperationDto.JSON_PLAN_IDENTIFIER;

    String JSON_ACCOUNT_TYPE = AccountingOperationDto.JSON_ACCOUNT_TYPE;

    String JSON_BENEFICIARY = AccountingOperationDto.JSON_BENEFICIARY;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingOperationCreateRequestDto extends AbstractNamableCreateRequestJsonDto
      implements AccountingOperationSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
    
    @JsonbProperty(JSON_PLAN_IDENTIFIER)
    private String planIdentifier;
    
    @JsonbProperty(JSON_ACCOUNT_TYPE)
    private AccountingAccountType accountType;

    @JsonbProperty(JSON_BENEFICIARY)
    private String beneficiary;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_OPERATION_COMPTABLE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des opérations comptables")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class AccountingOperationGetManyResponseDto
      extends AbstractGetByPageResponseDto<AccountingOperationDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AccountingOperationDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_OPERATION_COMPTABLE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une opération comptable")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_OPERATION_COMPTABLE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une opération comptable")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_OPERATION_COMPTABLE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une opération comptable")
  Response update(AccountingOperationUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingOperationUpdateRequestDto extends AbstractNamableUpdateRequestJsonDto
      implements AccountingOperationSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
    
    @JsonbProperty(JSON_PLAN_IDENTIFIER)
    private String planIdentifier;
    
    @JsonbProperty(JSON_ACCOUNT_TYPE)
    private AccountingAccountType accountType;

    @JsonbProperty(JSON_BENEFICIARY)
    private String beneficiary;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_OPERATION_COMPTABLE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une opération comptable")
  Response delete(DeleteOneRequestDto request);
}
