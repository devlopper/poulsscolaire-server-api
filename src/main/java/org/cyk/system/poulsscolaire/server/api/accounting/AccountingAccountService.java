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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link AccountingAccountDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AccountingAccountService.PATH)
@Tag(name = "Gestion des comptes comptables")
public interface AccountingAccountService extends SpecificService {

  String PATH = "comptes-comptables";

  String CREATE_IDENTIFIER = "CREATION_COMPTE_COMPTABLE";

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
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un compte comptable",
      description = "Ce service permet de créer un compte comptable")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AccountingAccountCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface AccountingAccountSaveRequestDto {
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
    AccountingAccountType getType();

    /**
     * Cette méthode permet d'assigner {@link AccountingAccountType}.
     *
     * @param type {@link AccountingAccountType}
     */
    void setType(AccountingAccountType type);

    String JSON_PLAN_IDENTIFIER = AccountingAccountDto.JSON_PLAN_IDENTIFIER;
    
    String JSON_TYPE = AccountingAccountDto.JSON_TYPE;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingAccountCreateRequestDto extends AbstractCodableNamableCreateRequestJsonDto
      implements AccountingAccountSaveRequestDto {

    @JsonbProperty(JSON_PLAN_IDENTIFIER)
    private String planIdentifier;
    
    @JsonbProperty(JSON_TYPE)
    private AccountingAccountType type;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_COMPTE_COMPTABLE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir plusieurs comptes comptables")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class AccountingAccountGetManyResponseDto
      extends AbstractGetByPageResponseDto<AccountingAccountDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AccountingAccountDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_COMPTE_COMPTABLE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir un compte comptable")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_COMPTE_COMPTABLE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un compte comptable")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_COMPTE_COMPTABLE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un compte comptable")
  Response update(AccountingAccountUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingAccountUpdateRequestDto extends AbstractCodableNamableUpdateRequestJsonDto
      implements AccountingAccountSaveRequestDto {
    @JsonbProperty(JSON_PLAN_IDENTIFIER)
    private String planIdentifier;
    
    @JsonbProperty(JSON_TYPE)
    private AccountingAccountType type;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_COMPTE_COMPTABLE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un compte comptable")
  Response delete(DeleteOneRequestDto request);
}
