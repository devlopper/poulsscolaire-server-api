package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractGetByPageResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
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
 * Cette interface représente les services de {@link FundingDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = FundingService.PATH)
@Tag(name = "Gestion des financements")
public interface FundingService extends SpecificService {

  String PATH = "financements";

  String CREATE_IDENTIFIER = "CREATION_FINANCEMENT";

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
  Response create(FundingCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface FundingSaveRequestDto {
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
    String getSourceIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link FundingSourceDto}.
     *
     * @param sourceIdentifier identifiant de {@link FundingSourceDto}
     */
    void setSourceIdentifier(String sourceIdentifier);

    Long getAmount();

    void setAmount(Long amount);

    String getJustification();

    void setJustification(String justification);


    String JSON_BUDGET_IDENTIFIER = FundingDto.JSON_BUDGET_IDENTIFIER;

    String JSON_DEPARTMENT_IDENTIFIER = FundingDto.JSON_DEPARTMENT_IDENTIFIER;

    String JSON_MONTH = FundingDto.JSON_MONTH;

    String JSON_ACCOUNTING_ACCOUNT_IDENTIFIER = FundingDto.JSON_ACCOUNTING_ACCOUNT_IDENTIFIER;

    String JSON_SOURCE_IDENTIFIER = FundingDto.JSON_SOURCE_IDENTIFIER;

    String JSON_AMOUNT = FundingDto.JSON_AMOUNT;

    String JSON_JUSTIFICATION = FundingDto.JSON_JUSTIFICATION;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class FundingCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements FundingSaveRequestDto {
    @JsonbProperty(JSON_BUDGET_IDENTIFIER)
    private String budgetIdentifier;

    @JsonbProperty(JSON_DEPARTMENT_IDENTIFIER)
    private String departmentIdentifier;

    @JsonbProperty(JSON_MONTH)
    private Month month;

    @JsonbProperty(JSON_ACCOUNTING_ACCOUNT_IDENTIFIER)
    private String accountingAccountIdentifier;

    @JsonbProperty(JSON_SOURCE_IDENTIFIER)
    private String sourceIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private Long amount;

    @JsonbProperty(JSON_JUSTIFICATION)
    private String justification;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_FINANCEMENT";

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
  public static class FundingGetManyResponseDto extends AbstractGetByPageResponseDto<FundingDto> {

    @JsonbProperty(JSON_DATAS)
    private List<FundingDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_FINANCEMENT";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_FINANCEMENT";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_FINANCEMENT";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(FundingUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class FundingUpdateRequestDto extends ByIdentifierRequestDto implements FundingSaveRequestDto {
    @JsonbProperty(JSON_BUDGET_IDENTIFIER)
    private String budgetIdentifier;

    @JsonbProperty(JSON_DEPARTMENT_IDENTIFIER)
    private String departmentIdentifier;

    @JsonbProperty(JSON_MONTH)
    private Month month;

    @JsonbProperty(JSON_ACCOUNTING_ACCOUNT_IDENTIFIER)
    private String accountingAccountIdentifier;

    @JsonbProperty(JSON_SOURCE_IDENTIFIER)
    private String sourceIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private Long amount;

    @JsonbProperty(JSON_JUSTIFICATION)
    private String justification;
  }

  /**
   * Identifiant du service de mise à jour de montant.
   */
  String UPDATE_AMOUNT_IDENTIFIER = "MISE_A_JOUR_MONTANT_FINANCEMENT";

  /**
   * Chemin du service de mise à jour de montant.
   */
  String UPDATE_AMOUNT_PATH = FundingUpdateAmountRequestDto.JSON_AMOUNT;

  /**
   * Cette méthode permet de mettre à jour montant de {@link FundingDto}.
   *
   * @param request requête
   * @return réponse
   */
  @Path(UPDATE_AMOUNT_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_AMOUNT_IDENTIFIER)
  @APIResponse(responseCode = "200",
      content = {@Content(schema = @Schema(implementation = FundingUpdateAmountResponseDto.class))})
  Response updateAmount(FundingUpdateAmountRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour de montant.
   *
   * @author Christian
   */
  @Getter
  @Setter
  class FundingUpdateAmountRequestDto extends ByIdentifierRequestDto {
    
    /**
     * Montant.
     */
    @JsonbProperty(JSON_AMOUNT)
    private long amount;

    /**
     * Filtre.
     */
    @JsonbProperty(JSON_FILTER)
    private FilterDto filter;
    
    /**
     * Identifiant json {@link #amount}.
     */
    public static final String JSON_AMOUNT = "montant";
    
    /**
     * Identifiant json {@link #filter}.
     */
    public static final String JSON_FILTER = "filtre";
  }

  /**
   * Cette classe représente la réponse de mise à jour de montant.
   *
   * @author Christian
   */
  @Getter
  @Setter
  class FundingUpdateAmountResponseDto extends IdentifiableResponseDto {
    /**
     * Représentation en chaine de caractères du montant total.
     */
    @JsonbProperty(JSON_TOTAL_AMOUNT_AS_STRING)
    private String totalAmountAsString;

    /**
     * Identifiant json {@link #totalAmountAsString}.
     */
    public static final String JSON_TOTAL_AMOUNT_AS_STRING = "montantTotalChaine";
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_FINANCEMENT";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);
  
  /**
   * Cette classe représente la requête de retour.
   *
   * @author AKM
   *
   */
  @Getter
  @Setter
  class FundingReturnRequestDto extends ByIdentifierRequestDto {

    /**
     * Raison.
     */
    @JsonbProperty(JSON_REASON)
    private String reason;

    /**
     * {@link #reason}.
     */
    public static final String JSON_REASON = "raison";
  }

  /**
   * Cette classe représente la réponse de mise à jour du statut.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class FundingStatusUpdateResponseDto extends IdentifiableResponseDto {

    /**
     * {@link FundingDto#getStatus()}.
     */
    @JsonbProperty(JSON_STATUS)
    private FundingStatus status;

    /**
     * {@link FundingDto#getStatusAsString()}.
     */
    @JsonbProperty(JSON_STATUS_AS_STRING)
    private String statusAsString;

    /**
     * {@link FundingDto#getStatusReason()}.
     */
    @JsonbProperty(JSON_REASON)
    private String reason;

    /**
     * {@link FundingDto#getTransmitable()}.
     */
    private Boolean transmitable;

    /**
     * {@link FundingDto#getAcceptable()}.
     */
    private Boolean acceptable;

    /**
     * {@link FundingDto#getReturnable()}.
     */
    private Boolean returnable;

    /**
     * {@link FundingDto#getApprovable()}.
     */
    private Boolean approvable;

    /**
     * Cette méthode permet d'initialiser la réponse à partir du statut.
     *
     * @param status {@link FundingStatus}
     * @param statusAsString représentation en chaine de caractères de
     *        {@link FundingStatus}
     * @param reason raison
     */
    public void initialize(FundingStatus status, String statusAsString, String reason) {
      this.status = status;
      this.statusAsString = statusAsString;
      this.reason = reason;
      transmitable = FundingStatus.TRANSMITTED.getPrevious().contains(status);
      acceptable = FundingStatus.ACCEPTED.getPrevious().contains(status);
      returnable = FundingStatus.RETURNED.getPrevious().contains(status);
      approvable = FundingStatus.APPROVED.getPrevious().contains(status);
    }

    /**
     * {@link FundingDto#JSON_STATUS}.
     */
    public static final String JSON_STATUS = FundingDto.JSON_STATUS;

    /**
     * {@link FundingDto#JSON_STATUS_AS_STRING}.
     */
    public static final String JSON_STATUS_AS_STRING = FundingDto.JSON_STATUS_AS_STRING;

    /**
     * {@link FundingDto#JSON_STATUS_REASON}.
     */
    public static final String JSON_REASON = FundingDto.JSON_STATUS_REASON;

    /**
     * {@link FundingDto#JSON_TRANSMITABLE}.
     */
    public static final String JSON_TRANSMITABLE = FundingDto.JSON_TRANSMITABLE;

    /**
     * {@link FundingDto#JSON_ACCEPTABLE}.
     */
    public static final String JSON_ACCEPTABLE = FundingDto.JSON_ACCEPTABLE;

    /**
     * {@link FundingDto#JSON_RETURNABLE}.
     */
    public static final String JSON_RETURNABLE = FundingDto.JSON_RETURNABLE;

    /**
     * {@link FundingDto#JSON_APPROVABLE}.
     */
    public static final String JSON_APPROVABLE = FundingDto.JSON_APPROVABLE;
  }

  /**
   * Identifiant du service de transmission.
   */
  String TRANSMIT_IDENTIFIER = "TRANSMISSION_BUDGET";

  /**
   * Chemin du service de transmission.
   */
  String TRANSMIT_PATH = "transmission";

  /**
   * Cette méthode permet de transmettre {@link FundingDto}.
   *
   * @param request requête
   * @return réponse
   */
  @Path(TRANSMIT_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response transmit(ByIdentifierRequestDto request);

  /**
   * Identifiant du service d'acceptation.
   */
  String ACCEPT_IDENTIFIER = "ACCEPTATION_BUDGET";

  /**
   * Chemin du service d'acceptation.
   */
  String ACCEPT_PATH = "acceptation";

  /**
   * Cette méthode permet d'accepter {@link FundingDto}.
   *
   * @param request requête
   * @return réponse
   */
  @Path(ACCEPT_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response accept(ByIdentifierRequestDto request);

  /**
   * Identifiant du service d'approbation.
   */
  String APPROVE_IDENTIFIER = "APPROBATION_BUDGET";

  /**
   * Chemin du service d'approbation.
   */
  String APPROVE_PATH = "approbation";

  /**
   * Cette méthode permet d'accepter {@link FundingDto}.
   *
   * @param request requête
   * @return réponse
   */
  @Path(APPROVE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response approve(ByIdentifierRequestDto request);

  /**
   * Identifiant du service de retour.
   */
  String RETURN_IDENTIFIER = "RETOUR_BUDGET";

  /**
   * Chemin du service de retour.
   */
  String RETURN_PATH = "retour";

  /**
   * Cette méthode permet de retourner {@link FundingDto}.
   *
   * @param request requête
   * @return réponse
   */
  @Path(RETURN_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response returnBack(FundingReturnRequestDto request);
}
