package org.cyk.system.poulsscolaire.server.api.fee;

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
 * Cette interface représente les services de {@link AmountDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AmountService.PATH)
@Tag(name = "Gestion des montants")
public interface AmountService extends SpecificService {

  String PATH = "montants";

  String CREATE_IDENTIFIER = "CREATION_MONTANT";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer un montant.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un montant",
      description = "Ce service permet de créer un montant")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AmountCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {AmountCreateRequestDto.FIELD_VALUE,
      AmountCreateRequestDto.FIELD_REGISTRATION_VALUE_PART, AmountCreateRequestDto.FIELD_OPTIONAL,
      AmountCreateRequestDto.FIELD_PAYMENT_ORDER_NUMBER, AmountCreateRequestDto.FIELD_RENEWABLE,
      AmountCreateRequestDto.FIELD_DEADLINE_IDENTIFIER, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class AmountCreateRequestDto extends AbstractAuditedRequestJsonDto implements AmountSaveData {
    @JsonbProperty(JSON_VALUE)
    private int value;

    @JsonbProperty(JSON_REGISTRATION_VALUE_PART)
    private Integer registrationValuePart;

    @JsonbProperty(JSON_OPTIONAL)
    private Boolean optional;

    @JsonbProperty(JSON_PAYMENT_ORDER_NUMBER)
    private Integer paymentOrderNumber;

    @JsonbProperty(JSON_RENEWABLE)
    private Boolean renewable;

    @JsonbProperty(JSON_DEADLINE_IDENTIFIER)
    private String deadlineIdentifier;

    public static final String FIELD_VALUE = "value";
    public static final String FIELD_REGISTRATION_VALUE_PART = "registrationValuePart";
    public static final String FIELD_OPTIONAL = "optional";
    public static final String FIELD_PAYMENT_ORDER_NUMBER = "paymentOrderNumber";
    public static final String FIELD_RENEWABLE = "renewable";
    public static final String FIELD_DEADLINE_IDENTIFIER = "deadlineIdentifier";
  }

  /**
   * Cette interface représente les informations d'enregistrement d'un montant.
   *
   * @author Christian
   *
   */
  interface AmountSaveData {
    int getValue();

    Integer getRegistrationValuePart();

    Boolean getOptional();

    Integer getPaymentOrderNumber();

    Boolean getRenewable();

    String getDeadlineIdentifier();

    String JSON_VALUE = AmountDto.JSON_VALUE;
    String JSON_REGISTRATION_VALUE_PART = AmountDto.JSON_REGISTRATION_VALUE_PART;
    String JSON_OPTIONAL = AmountDto.JSON_OPTIONAL;
    String JSON_PAYMENT_ORDER_NUMBER = AmountDto.JSON_PAYMENT_ORDER_NUMBER;
    String JSON_RENEWABLE = AmountDto.JSON_RENEWABLE;
    String JSON_DEADLINE_IDENTIFIER = AmountDto.JSON_DEADLINE_IDENTIFIER;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_MONTANT";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des montants")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class GetManyResponseDto extends AbstractGetByPageResponseDto<AmountDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AmountDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_MONTANT";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir un montant")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_MONTANT";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un montant")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_MONTANT";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un montant")
  Response update(AmountUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {ByIdentifierRequestDto.FIELD_IDENTIFIER,
      AmountUpdateRequestDto.FIELD_VALUE, AmountUpdateRequestDto.FIELD_REGISTRATION_VALUE_PART,
      AmountUpdateRequestDto.FIELD_OPTIONAL, AmountUpdateRequestDto.FIELD_PAYMENT_ORDER_NUMBER,
      AmountUpdateRequestDto.FIELD_RENEWABLE, AmountUpdateRequestDto.FIELD_DEADLINE_IDENTIFIER,
      AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class AmountUpdateRequestDto extends ByIdentifierRequestDto implements AmountSaveData {
    @JsonbProperty(JSON_VALUE)
    private int value;

    @JsonbProperty(JSON_REGISTRATION_VALUE_PART)
    private Integer registrationValuePart;

    @JsonbProperty(JSON_OPTIONAL)
    private Boolean optional;

    @JsonbProperty(JSON_PAYMENT_ORDER_NUMBER)
    private Integer paymentOrderNumber;

    @JsonbProperty(JSON_RENEWABLE)
    private Boolean renewable;

    @JsonbProperty(JSON_DEADLINE_IDENTIFIER)
    private String deadlineIdentifier;

    public static final String FIELD_VALUE = "value";
    public static final String FIELD_REGISTRATION_VALUE_PART = "registrationValuePart";
    public static final String FIELD_OPTIONAL = "optional";
    public static final String FIELD_PAYMENT_ORDER_NUMBER = "paymentOrderNumber";
    public static final String FIELD_RENEWABLE = "renewable";
    public static final String FIELD_DEADLINE_IDENTIFIER = "deadlineIdentifier";
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_MONTANT";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un montant")
  Response delete(DeleteOneRequestDto request);
}
