package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.response.AbstractGetByPageResponseDto;
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
 * Cette interface représente les services de {@link PaymentAdjustedFeeDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = PaymentAdjustedFeeService.PATH)
@Tag(name = "Gestion des paiements de frais ajusté")
public interface PaymentAdjustedFeeService extends SpecificService {

  String PATH = "paiements-frais-ajustes";

  String CREATE_IDENTIFIER = "CREATION_PAIEMENT_FRAIS_AJUSTE";

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
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un paiement de frais ajusté",
      description = "Ce service permet de créer un paiement de frais ajusté")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(PaymentAdjustedFeeCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {PaymentAdjustedFeeCreateRequestDto.FIELD_PAYMENT_IDENTIFIER,
      PaymentAdjustedFeeCreateRequestDto.FIELD_ADJUSTED_FEE_IDENTIFIER,
      PaymentAdjustedFeeCreateRequestDto.FIELD_AMOUNT, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class PaymentAdjustedFeeCreateRequestDto extends AbstractAuditedRequestJsonDto {
    @JsonbProperty(JSON_PAYMENT_IDENTIFIER)
    private String paymentIdentifier;

    @JsonbProperty(JSON_ADJUSTED_FEE_IDENTIFIER)
    private String adjustedFeeIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;

    public static final String FIELD_PAYMENT_IDENTIFIER = "paymentIdentifier";
    public static final String FIELD_ADJUSTED_FEE_IDENTIFIER = "adjustedFeeIdentifier";
    public static final String FIELD_AMOUNT = "amount";

    public static final String JSON_PAYMENT_IDENTIFIER =
        PaymentAdjustedFeeDto.JSON_PAYMENT_IDENTIFIER;
    public static final String JSON_ADJUSTED_FEE_IDENTIFIER =
        PaymentAdjustedFeeDto.JSON_ADJUSTED_FEE_IDENTIFIER;
    public static final String JSON_AMOUNT = PaymentAdjustedFeeDto.JSON_AMOUNT;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_PAIEMENT_FRAIS_AJUSTE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des paiements")
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
      extends AbstractGetByPageResponseDto<PaymentAdjustedFeeDto> {

    @JsonbProperty(JSON_DATAS)
    private List<PaymentAdjustedFeeDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_PAIEMENT_FRAIS_AJUSTE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir un paiement de frais ajusté")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_PAIEMENT_FRAIS_AJUSTE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un paiement de frais ajusté")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_PAIEMENT_FRAIS_AJUSTE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un paiement de frais ajusté")
  Response update(PaymentAdjustedFeeUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {ByIdentifierRequestDto.FIELD_IDENTIFIER,
      PaymentAdjustedFeeUpdateRequestDto.FIELD_PAYMENT_IDENTIFIER,
      PaymentAdjustedFeeUpdateRequestDto.FIELD_ADJUSTED_FEE_IDENTIFIER,
      PaymentAdjustedFeeUpdateRequestDto.FIELD_AMOUNT, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class PaymentAdjustedFeeUpdateRequestDto extends ByIdentifierRequestDto {
    @JsonbProperty(JSON_PAYMENT_IDENTIFIER)
    private String modeIdentifier;

    @JsonbProperty(JSON_ADJUSTED_FEE_IDENTIFIER)
    private String adjustedFeeIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;

    public static final String FIELD_PAYMENT_IDENTIFIER = "paymentIdentifier";
    public static final String FIELD_ADJUSTED_FEE_IDENTIFIER = "adjustedFeeIdentifier";
    public static final String FIELD_AMOUNT = "amount";

    public static final String JSON_PAYMENT_IDENTIFIER =
        PaymentAdjustedFeeDto.JSON_PAYMENT_IDENTIFIER;
    public static final String JSON_ADJUSTED_FEE_IDENTIFIER =
        PaymentAdjustedFeeDto.JSON_ADJUSTED_FEE_IDENTIFIER;
    public static final String JSON_AMOUNT = PaymentAdjustedFeeDto.JSON_AMOUNT;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_PAIEMENT_FRAIS_AJUSTE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un paiement de frais ajusté")
  Response delete(DeleteOneRequestDto request);
}
