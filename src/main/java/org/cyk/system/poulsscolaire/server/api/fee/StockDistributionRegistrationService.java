package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.core.segregation.HasQuantityDto;
import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
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
import org.cyk.system.poulsscolaire.server.api.registration.RegistrationDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link StockDistributionRegistrationDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = StockDistributionRegistrationService.PATH)
@Tag(name = "Gestion des distributions de stock à inscription")
public interface StockDistributionRegistrationService extends SpecificService {

  String PATH = "distributions-stock-inscription";

  String CREATE_IDENTIFIER = "CREATION_DISTRIBUTION_STOCK_INSCRIPTION";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une relation d'identité.
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
  Response create(StockDistributionRegistrationCreateRequestDto request);

  /**
   * Cette interface représente une reuqête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface StockDistributionRegistrationSaveRequest {
    String getDistributionIdentifier();

    void setDistributionIdentifier(String distributionIdentifier);

    String getRegistrationIdentifier();

    void setRegistrationIdentifier(String registrationIdentifier);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    String JSON_DISTRIBUTION_IDENTIFIER = StockDistributionDto.JSON_THIS_IDENTIFIER;
    String JSON_REGISTRATION_IDENTIFIER = RegistrationDto.JSON_THIS_IDENTIFIER;
    String JSON_QUANTITY = StockMovementDto.JSON_QUANTITY;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockDistributionRegistrationCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements StockDistributionRegistrationSaveRequest {
    @JsonbProperty(JSON_DISTRIBUTION_IDENTIFIER)
    private String distributionIdentifier;

    @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
    private String registrationIdentifier;

    @JsonbProperty(JSON_QUANTITY)
    private Integer quantity;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_DISTRIBUTION_STOCK_INSCRIPTION";

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
  public static class StockDistributionRegistrationGetManyResponseDto
      extends AbstractGetByPageResponseDto<StockDistributionRegistrationDto> {

    @JsonbProperty(JSON_DATAS)
    private List<StockDistributionRegistrationDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_DISTRIBUTION_STOCK_INSCRIPTION";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_DISTRIBUTION_STOCK_INSCRIPTION";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_DISTRIBUTION_STOCK_INSCRIPTION";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(StockDistributionRegistrationUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockDistributionRegistrationUpdateRequestDto extends ByIdentifierRequestDto
      implements StockDistributionRegistrationSaveRequest {
    @JsonbProperty(JSON_DISTRIBUTION_IDENTIFIER)
    private String distributionIdentifier;

    @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
    private String registrationIdentifier;

    @JsonbProperty(JSON_QUANTITY)
    private Integer quantity;
  }

  /**
   * Identifiant du service de mise à jour de quantité.
   */
  String UPDATE_QUANTITY_IDENTIFIER = "MISE_A_JOUR_QUANTITE_DISTRIBUTION_STOCK_INSCRIPTION";

  /**
   * Chemin du service de mise à jour de quantité.
   */
  String UPDATE_QUANTITY_PATH = HasQuantityDto.JSON_QUANTITY;

  /**
   * Cette méthode permet de mettre à jour la quantité.
   *
   * @param request requête
   * @return réponse
   */
  @Path(UPDATE_QUANTITY_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_QUANTITY_IDENTIFIER)
  @APIResponse(responseCode = "200",
      content = {@Content(schema = @Schema(implementation = IdentifiableResponseDto.class))})
  Response updateQuantity(StockDistributionRegistrationUpdateQuantityRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour de quantité.
   *
   * @author Christian
   */
  @Getter
  @Setter
  class StockDistributionRegistrationUpdateQuantityRequestDto extends ByIdentifierRequestDto
      implements HasQuantityDto {
    /**
     * Montant.
     */
    @JsonbProperty(JSON_QUANTITY)
    private Integer quantity;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_DISTRIBUTION_STOCK_INSCRIPTION";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);
}
