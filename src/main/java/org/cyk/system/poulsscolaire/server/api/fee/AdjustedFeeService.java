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
 * Cette interface représente les services de {@link AdjustedFeeDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = AdjustedFeeService.PATH)
@Tag(name = "Gestion des frais ajustés")
public interface AdjustedFeeService extends SpecificService {

  String PATH = "frais-ajustes";

  String CREATE_IDENTIFIER = "CREATION_FRAIS_AJUSTE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer un frais.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un frais",
      description = "Ce service permet de créer un frais")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(AdjustedFeeCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {AdjustedFeeCreateRequestDto.FIELD_REGISTRATION_IDENTIFIER,
      AdjustedFeeCreateRequestDto.FIELD_FEE_IDENTIFIER,
      AmountService.AmountCreateRequestDto.FIELD_VALUE,
      AmountService.AmountCreateRequestDto.FIELD_REGISTRATION_VALUE_PART,
      AmountService.AmountCreateRequestDto.FIELD_OPTIONAL,
      AmountService.AmountCreateRequestDto.FIELD_PAYMENT_ORDER_NUMBER,
      AmountService.AmountCreateRequestDto.FIELD_RENEWABLE,
      AmountService.AmountCreateRequestDto.FIELD_DEADLINE_IDENTIFIER,
      AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class AdjustedFeeCreateRequestDto extends AmountService.AmountCreateRequestDto {
    @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
    private String registrationIdentifier;

    @JsonbProperty(JSON_FEE_IDENTIFIER)
    private String feeIdentifier;

    public static final String FIELD_REGISTRATION_IDENTIFIER = "registrationIdentifier";
    public static final String FIELD_FEE_IDENTIFIER = "feeIdentifier";

    public static final String JSON_REGISTRATION_IDENTIFIER = "idInscription";
    public static final String JSON_FEE_IDENTIFIER = "idRubrique";
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_FRAIS_AJUSTE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des frais")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class GetManyResponseDto extends AbstractGetByPageResponseDto<AdjustedFeeDto> {

    @JsonbProperty(JSON_DATAS)
    private List<AdjustedFeeDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_FRAIS_AJUSTE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER, description = "Ce service permet d'obtenir un frais")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_FRAIS_AJUSTE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un frais")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_FRAIS_AJUSTE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un frais")
  Response update(AdjustedFeeUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {ByIdentifierRequestDto.FIELD_IDENTIFIER,
      AdjustedFeeUpdateRequestDto.FIELD_REGISTRATION_IDENTIFIER,
      AdjustedFeeUpdateRequestDto.FIELD_FEE_IDENTIFIER,
      AmountService.AmountUpdateRequestDto.FIELD_VALUE,
      AmountService.AmountUpdateRequestDto.FIELD_REGISTRATION_VALUE_PART,
      AmountService.AmountUpdateRequestDto.FIELD_OPTIONAL,
      AmountService.AmountUpdateRequestDto.FIELD_PAYMENT_ORDER_NUMBER,
      AmountService.AmountUpdateRequestDto.FIELD_RENEWABLE,
      AmountService.AmountUpdateRequestDto.FIELD_DEADLINE_IDENTIFIER,
      AbstractRequestDto.FIELD_AUDIT_WHO, AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class AdjustedFeeUpdateRequestDto extends AmountService.AmountUpdateRequestDto {
    @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
    private String registrationIdentifier;

    @JsonbProperty(JSON_FEE_IDENTIFIER)
    private String feeIdentifier;

    public static final String FIELD_REGISTRATION_IDENTIFIER = "registrationIdentifier";
    public static final String FIELD_FEE_IDENTIFIER = "feeIdentifier";

    public static final String JSON_REGISTRATION_IDENTIFIER = "idInscription";
    public static final String JSON_FEE_IDENTIFIER = "idRubrique";
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_FRAIS_AJUSTE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un frais")
  Response delete(DeleteOneRequestDto request);
}
