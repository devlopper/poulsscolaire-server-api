package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractNamableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractNamableUpdateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
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
 * Cette interface représente les services de {@link BudgetDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = BudgetService.PATH)
@Tag(name = "Gestion des budgets")
public interface BudgetService extends SpecificService {

  String PATH = "budgets";

  String CREATE_IDENTIFIER = "CREATION_BUDGET";

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
  Response create(BudgetCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface BudgetSaveRequestDto {
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
    String getAccountingPlanIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link AccountingPlanDto}.
     *
     * @param accountingPlanIdentifier identifiant de {@link AccountingPlanDto}
     */
    void setAccountingPlanIdentifier(String accountingPlanIdentifier);

    Integer getYear();

    void setYear(Integer year);

    String JSON_SCHOOL_IDENTIFIER = BudgetDto.JSON_SCHOOL_IDENTIFIER;

    String JSON_ACCOUNTING_PLAN_IDENTIFIER = BudgetDto.JSON_ACCOUNTING_PLAN_IDENTIFIER;

    String JSON_YEAR = BudgetDto.JSON_YEAR;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class BudgetCreateRequestDto extends AbstractNamableCreateRequestJsonDto
      implements BudgetSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_ACCOUNTING_PLAN_IDENTIFIER)
    private String accountingPlanIdentifier;

    @JsonbProperty(JSON_YEAR)
    private Integer year;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_BUDGET";

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
  public static class BudgetGetManyResponseDto extends AbstractGetByPageResponseDto<BudgetDto> {

    @JsonbProperty(JSON_DATAS)
    private List<BudgetDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_BUDGET";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_BUDGET";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_BUDGET";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(BudgetUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class BudgetUpdateRequestDto extends AbstractNamableUpdateRequestJsonDto
      implements BudgetSaveRequestDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_ACCOUNTING_PLAN_IDENTIFIER)
    private String accountingPlanIdentifier;

    @JsonbProperty(JSON_YEAR)
    private Integer year;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_BUDGET";

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
  class BudgetReturnRequestDto extends ByIdentifierRequestDto {

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
  class BudgetStatusUpdateResponseDto extends IdentifiableResponseDto {

    /**
     * {@link BudgetDto#getStatus()}.
     */
    @JsonbProperty(JSON_STATUS)
    private BudgetStatus status;

    /**
     * {@link BudgetDto#getStatusAsString()}.
     */
    @JsonbProperty(JSON_STATUS_AS_STRING)
    private String statusAsString;

    /**
     * {@link BudgetDto#getStatusReason()}.
     */
    @JsonbProperty(JSON_REASON)
    private String reason;

    /**
     * {@link BudgetDto#getTransmitable()}.
     */
    private Boolean transmitable;

    /**
     * {@link BudgetDto#getAcceptable()}.
     */
    private Boolean acceptable;

    /**
     * {@link BudgetDto#getReturnable()}.
     */
    private Boolean returnable;

    /**
     * {@link BudgetDto#getApprovable()}.
     */
    private Boolean approvable;

    /**
     * Cette méthode permet d'initialiser la réponse à partir du statut.
     *
     * @param status {@link BudgetStatus}
     * @param statusAsString représentation en chaine de caractères de
     *        {@link BudgetStatus}
     * @param reason raison
     */
    public void initialize(BudgetStatus status, String statusAsString, String reason) {
      this.status = status;
      this.statusAsString = statusAsString;
      this.reason = reason;
      transmitable = BudgetStatus.TRANSMITTED.getPrevious().contains(status);
      acceptable = BudgetStatus.ACCEPTED.getPrevious().contains(status);
      returnable = BudgetStatus.RETURNED.getPrevious().contains(status);
      approvable = BudgetStatus.APPROVED.getPrevious().contains(status);
    }

    /**
     * {@link BudgetDto#JSON_STATUS}.
     */
    public static final String JSON_STATUS = BudgetDto.JSON_STATUS;

    /**
     * {@link BudgetDto#JSON_STATUS_AS_STRING}.
     */
    public static final String JSON_STATUS_AS_STRING = BudgetDto.JSON_STATUS_AS_STRING;

    /**
     * {@link BudgetDto#JSON_STATUS_REASON}.
     */
    public static final String JSON_REASON = BudgetDto.JSON_STATUS_REASON;

    /**
     * {@link BudgetDto#JSON_TRANSMITABLE}.
     */
    public static final String JSON_TRANSMITABLE = BudgetDto.JSON_TRANSMITABLE;

    /**
     * {@link BudgetDto#JSON_ACCEPTABLE}.
     */
    public static final String JSON_ACCEPTABLE = BudgetDto.JSON_ACCEPTABLE;

    /**
     * {@link BudgetDto#JSON_RETURNABLE}.
     */
    public static final String JSON_RETURNABLE = BudgetDto.JSON_RETURNABLE;

    /**
     * {@link BudgetDto#JSON_APPROVABLE}.
     */
    public static final String JSON_APPROVABLE = BudgetDto.JSON_APPROVABLE;
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
   * Cette méthode permet de transmettre {@link BudgetDto}.
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
   * Cette méthode permet d'accepter {@link BudgetDto}.
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
   * Cette méthode permet d'accepter {@link BudgetDto}.
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
   * Cette méthode permet de retourner {@link BudgetDto}.
   *
   * @param request requête
   * @return réponse
   */
  @Path(RETURN_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response returnBack(BudgetReturnRequestDto request);
}
