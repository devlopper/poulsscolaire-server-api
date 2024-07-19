package org.cyk.system.poulsscolaire.server.api.fee;

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
 * Cette interface représente les services de {@link AdjustedFeePaymentDeadlineDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AdjustedFeePaymentDeadlineService.PATH)
@Tag(name = "Gestion des échéances de paiement des frais ajustés")
public interface AdjustedFeePaymentDeadlineService extends SpecificService {

  String PATH = "echeances-paiements-frais-ajustes";

  String CREATE_IDENTIFIER = "CREATION_ECHEANCE_PAIEMENT_FRAIS_AJUSTE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une échéance de paiement de frais ajusté.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER,
      summary = "Création d'une échéance de paiement de frais ajusté",
      description = "Ce service permet de créer une échéance de paiement de frais ajusté")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AdjustedFeePaymentDeadlineCreateRequestDto request);

  /**
   * Cette classe représente la requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface SaveRequestDto {
    String getAdjustedFeeIdentifier();

    void setAdjustedFeeIdentifier(String identifier);

    String getDeadlineIdentifier();

    void setDeadlineIdentifier(String identifier);

    int getAmount();

    void setAmount(int amount);

    String JSON_ADJUSTED_FEE_IDENTIFIER = "idFraisAjuste";
    String JSON_DEADLINE_IDENTIFIER = "idEcheance";
    String JSON_AMOUNT = "montant";
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AdjustedFeePaymentDeadlineCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements SaveRequestDto {
    @JsonbProperty(JSON_ADJUSTED_FEE_IDENTIFIER)
    private String adjustedFeeIdentifier;

    @JsonbProperty(JSON_DEADLINE_IDENTIFIER)
    private String deadlineIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_ECHEANCE_PAIEMENT_FRAIS_AJUSTE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des échéances de paiements de frais ajustés")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class GetManyResponseDto
      extends AbstractGetByPageResponseDto<AdjustedFeePaymentDeadlineDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AdjustedFeePaymentDeadlineDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_ECHEANCE_PAIEMENT_FRAIS_AJUSTE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une échéance de paiement de frais ajusté")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_ECHEANCE_PAIEMENT_FRAIS_AJUSTE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une échéance "
          + "de paiement de frais ajusté")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_ECHEANCE_PAIEMENT_FRAIS_AJUSTE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une échéance de paiement de frais ajusté")
  Response update(AdjustedFeePaymentDeadlineUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class AdjustedFeePaymentDeadlineUpdateRequestDto extends ByIdentifierRequestDto
      implements SaveRequestDto {
    @JsonbProperty(JSON_ADJUSTED_FEE_IDENTIFIER)
    private String adjustedFeeIdentifier;

    @JsonbProperty(JSON_DEADLINE_IDENTIFIER)
    private String deadlineIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_ECHEANCE_PAIEMENT_FRAIS_AJUSTE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une échéance de paiement de frais ajusté")
  Response delete(DeleteOneRequestDto request);
}
