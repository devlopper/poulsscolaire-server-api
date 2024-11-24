package org.cyk.system.poulsscolaire.server.api.accounting;

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
import java.time.Month;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.DepartmentDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link BudgetLineDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = BudgetLineService.PATH)
@Tag(name = "Gestion des lignes de budgets")
public interface BudgetLineService extends SpecificService {

  String PATH = "lignes-budgets";

  String CREATE_IDENTIFIER = "CREATION_LIGNE_BUDGET";

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
  @Operation(operationId = CREATE_IDENTIFIER)
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(BudgetLineCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface BudgetLineSaveRequestDto {
    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link BudgetDto}.
     *
     * @return identifiant de {@link BudgetDto}
     */
    String getBudgetIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link BudgetDto}.
     *
     * @param budgetIdentifier identifiant de {@link BudgetDto}
     */
    void setBudgetIdentifier(String budgetIdentifier);

    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link DepartmentDto}.
     *
     * @return identifiant de {@link DepartmentDto}
     */
    String getDepartmentIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link DepartmentDto}.
     *
     * @param departmentIdentifier identifiant de {@link DepartmentDto}
     */
    void setDepartmentIdentifier(String departmentIdentifier);

    Month getMonth();

    void setMonth(Month monthIndex);

    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link AccountingAccountDto}.
     *
     * @return identifiant de {@link AccountingAccountDto}
     */
    String getAccountingAccountIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link AccountingAccountDto}.
     *
     * @param accountingAccountIdentifier identifiant de {@link AccountingAccountDto}
     */
    void setAccountingAccountIdentifier(String accountingAccountIdentifier);

    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link FundingSourceDto}.
     *
     * @return identifiant de {@link FundingSourceDto}
     */
    String getFundingSourceIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link FundingSourceDto}.
     *
     * @param fundingSourceIdentifier identifiant de {@link FundingSourceDto}
     */
    void setFundingSourceIdentifier(String fundingSourceIdentifier);

    Long getAmount();

    void setAmount(Long amount);

    String getJustification();

    void setJustification(String justification);


    String JSON_BUDGET_IDENTIFIER = BudgetLineDto.JSON_BUDGET_IDENTIFIER;

    String JSON_DEPARTMENT_IDENTIFIER = BudgetLineDto.JSON_DEPARTMENT_IDENTIFIER;

    String JSON_MONTH = BudgetLineDto.JSON_MONTH;

    String JSON_ACCOUNTING_ACCOUNT_IDENTIFIER = BudgetLineDto.JSON_ACCOUNTING_ACCOUNT_IDENTIFIER;

    String JSON_FUNDING_SOURCE_IDENTIFIER = BudgetLineDto.JSON_FUNDING_SOURCE_IDENTIFIER;

    String JSON_AMOUNT = BudgetLineDto.JSON_AMOUNT;

    String JSON_JUSTIFICATION = BudgetLineDto.JSON_JUSTIFICATION;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class BudgetLineCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements BudgetLineSaveRequestDto {
    @JsonbProperty(JSON_BUDGET_IDENTIFIER)
    private String budgetIdentifier;

    @JsonbProperty(JSON_DEPARTMENT_IDENTIFIER)
    private String departmentIdentifier;
    
    @JsonbProperty(JSON_MONTH)
    private Month month;
    
    @JsonbProperty(JSON_ACCOUNTING_ACCOUNT_IDENTIFIER)
    private String accountingAccountIdentifier;
    
    @JsonbProperty(JSON_FUNDING_SOURCE_IDENTIFIER)
    private String fundingSourceIdentifier;
    
    @JsonbProperty(JSON_AMOUNT)
    private Long amount;
    
    @JsonbProperty(JSON_JUSTIFICATION)
    private String justification;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_LIGNE_BUDGET";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER)
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class BudgetLineGetManyResponseDto
      extends AbstractGetByPageResponseDto<BudgetLineDto> {

    @JsonbProperty(JSON_DATAS)
    private List<BudgetLineDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_LIGNE_BUDGET";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_LIGNE_BUDGET";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_LIGNE_BUDGET";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(BudgetLineUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class BudgetLineUpdateRequestDto extends ByIdentifierRequestDto
      implements BudgetLineSaveRequestDto {
    @JsonbProperty(JSON_BUDGET_IDENTIFIER)
    private String budgetIdentifier;

    @JsonbProperty(JSON_DEPARTMENT_IDENTIFIER)
    private String departmentIdentifier;
    
    @JsonbProperty(JSON_MONTH)
    private Month month;
    
    @JsonbProperty(JSON_ACCOUNTING_ACCOUNT_IDENTIFIER)
    private String accountingAccountIdentifier;
    
    @JsonbProperty(JSON_FUNDING_SOURCE_IDENTIFIER)
    private String fundingSourceIdentifier;
    
    @JsonbProperty(JSON_AMOUNT)
    private Long amount;
    
    @JsonbProperty(JSON_JUSTIFICATION)
    private String justification;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_LIGNE_BUDGET";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);
}
