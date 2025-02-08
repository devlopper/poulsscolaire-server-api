package org.cyk.system.poulsscolaire.server.api.registration;

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
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link SubsidyDecisionPaymentDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = SubsidyDecisionPaymentService.PATH)
@Tag(name = "Gestion des paiements de décision de subvention")
public interface SubsidyDecisionPaymentService extends SpecificService {

  String PATH = "paiements-decisions-subventions";

  /**
   * Cette interface représente une reuqête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface SubsidyDecisionPaymentSaveRequest {
    String getSubsidyDecisionIdentifier();

    void setSubsidyDecisionIdentifier(String subsidyDecisionIdentifier);

    int getAmount();

    void setAmount(int amount);

    String JSON_SUBSIDY_DECISION_IDENTIFIER =
        SubsidyDecisionPaymentDto.JSON_SUBSIDY_DECISION_IDENTIFIER;
    String JSON_AMOUNT = SubsidyDecisionPaymentDto.JSON_AMOUNT;
  }

  String CREATE_IDENTIFIER = "CREATION_PAIEMENT_DECISION_SUBVENTION";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer un paiement de frais ajusté.
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
  Response create(SubsidyDecisionPaymentCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SubsidyDecisionPaymentCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements SubsidyDecisionPaymentSaveRequest {
    @JsonbProperty(JSON_SUBSIDY_DECISION_IDENTIFIER)
    private String subsidyDecisionIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_PAIEMENT_DECISION_SUBVENTION";

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
  public static class SubsidyDecisionPaymentGetManyResponseDto
      extends AbstractGetByPageResponseDto<SubsidyDecisionPaymentDto> {

    @JsonbProperty(JSON_DATAS)
    private List<SubsidyDecisionPaymentDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_PAIEMENT_DECISION_SUBVENTION";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_PAIEMENT_DECISION_SUBVENTION";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_PAIEMENT_DECISION_SUBVENTION";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(SubsidyDecisionPaymentUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SubsidyDecisionPaymentUpdateRequestDto extends ByIdentifierRequestDto
      implements SubsidyDecisionPaymentSaveRequest {
    @JsonbProperty(JSON_SUBSIDY_DECISION_IDENTIFIER)
    private String subsidyDecisionIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_PAIEMENT_DECISION_SUBVENTION";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);
}
