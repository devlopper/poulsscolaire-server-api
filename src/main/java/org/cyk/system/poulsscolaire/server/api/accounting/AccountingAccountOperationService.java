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
 * Cette interface représente les services de {@link AccountingAccountOperationDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AccountingAccountOperationService.PATH)
@Tag(name = "Gestion des opérations de comptes comptables")
public interface AccountingAccountOperationService extends SpecificService {

  String PATH = "operations-comptes-comptables";

  String CREATE_IDENTIFIER = "CREATION_OPERATION_COMPTE_COMPTABLE";

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
  @Operation(operationId = CREATE_IDENTIFIER,
      summary = "Création d'une opération de compte comptable",
      description = "Ce service permet de créer une opération de compte comptable")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AccountingAccountOperationCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface AccountingAccountOperationSaveRequestDto {
    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link AccountingAccountDto}.
     *
     * @return identifiant de {@link AccountingAccountDto}
     */
    String getAccountIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link AccountingAccountDto}.
     *
     * @param accountIdentifier identifiant de {@link AccountingAccountDto}
     */
    void setAccountIdentifier(String accountIdentifier);
    
    /**
     * Cette méthode permet d'obtenir le montant.
     *
     * @return montant
     */
    Integer getAmount();

    /**
     * Cette méthode permet d'assigner le montant.
     *
     * @param amount montant
     */
    void setAmount(Integer amount);

    String JSON_ACCOUNT_IDENTIFIER = AccountingAccountOperationDto.JSON_ACCOUNT_IDENTIFIER;
    
    String JSON_AMOUNT = AccountingAccountOperationDto.JSON_AMOUNT;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingAccountOperationCreateRequestDto
      extends AbstractCodableNamableCreateRequestJsonDto {

  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_OPERATION_COMPTE_COMPTABLE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des opérations de comptes comptables")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class AccountingAccountOperationGetManyResponseDto
      extends AbstractGetByPageResponseDto<AccountingAccountOperationDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AccountingAccountOperationDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_OPERATION_COMPTE_COMPTABLE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une opération de compte comptable")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_OPERATION_COMPTE_COMPTABLE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une opération de compte comptable")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_OPERATION_COMPTE_COMPTABLE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une opération de compte comptable")
  Response update(AccountingAccountOperationUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AccountingAccountOperationUpdateRequestDto
      extends AbstractCodableNamableUpdateRequestJsonDto {

  }

  String DELETE_IDENTIFIER = "SUPPRESSION_OPERATION_COMPTE_COMPTABLE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une opération de compte comptable")
  Response delete(DeleteOneRequestDto request);
}
