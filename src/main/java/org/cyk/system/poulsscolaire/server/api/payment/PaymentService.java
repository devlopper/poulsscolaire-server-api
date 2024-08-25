package org.cyk.system.poulsscolaire.server.api.payment;

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
 * Cette interface représente les services de {@link PaymentDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = PaymentService.PATH)
@Tag(name = "Gestion des paiements")
public interface PaymentService extends SpecificService {

  String PATH = "paiements";

  String CREATE_IDENTIFIER = "CREATION_PAIEMENT";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer un paiement.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'un paiement",
      description = "Ce service permet de créer un paiement")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(PaymentCreateRequestDto request);

  /**
   * Cette interface représente la requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface SaveRequestDto {
    String getRegistrationIdentifier();

    void setRegistrationIdentifier(String identifier);

    String getModeIdentifier();

    void setModeIdentifier(String identifier);

    int getAmount();

    void setAmount(int amount);

    String getInitiator();

    void setInitiator(String identifier);
    
    String JSON_REGISTRATION_IDENTIFIER = PaymentDto.JSON_REGISTRATION_IDENTIFIER;
    String JSON_MODE_IDENTIFIER = PaymentDto.JSON_MODE_IDENTIFIER;
    String JSON_AMOUNT = PaymentDto.JSON_AMOUNT;
    String JSON_INITIATOR = PaymentDto.JSON_INITIATOR;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class PaymentCreateRequestDto extends AbstractAuditedRequestJsonDto implements SaveRequestDto {
    @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
    private String registrationIdentifier;

    @JsonbProperty(JSON_MODE_IDENTIFIER)
    private String modeIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
    
    @JsonbProperty(JSON_INITIATOR)
    private String initiator;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_PAIEMENT";

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
  public static class PaymentGetManyResponseDto extends AbstractGetByPageResponseDto<PaymentDto> {

    @JsonbProperty(JSON_DATAS)
    private List<PaymentDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_PAIEMENT";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir un paiement")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_PAIEMENT";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un paiement")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_PAIEMENT";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un paiement")
  Response update(PaymentUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class PaymentUpdateRequestDto extends ByIdentifierRequestDto implements SaveRequestDto {
    @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
    private String registrationIdentifier;

    @JsonbProperty(JSON_MODE_IDENTIFIER)
    private String modeIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
    
    @JsonbProperty(JSON_INITIATOR)
    private String initiator;
  }

  String CANCEL_IDENTIFIER = "ANNULATION_PAIEMENT";

  String CANCEL_PATH = "annulation";

  @Path(CANCEL_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = CANCEL_IDENTIFIER,
      description = "Ce service permet d'annuler un paiement")
  Response cancel(ByIdentifierRequestDto request);

  String DELETE_IDENTIFIER = "SUPPRESSION_PAIEMENT";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un paiement")
  Response delete(DeleteOneRequestDto request);
}
