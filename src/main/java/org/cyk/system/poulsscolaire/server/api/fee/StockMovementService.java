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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link StockMovementDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = StockMovementService.PATH)
@Tag(name = "Gestion des mouvements de stocks")
public interface StockMovementService extends SpecificService {

  String PATH = "mouvements-stocks";

  String CREATE_IDENTIFIER = "CREATION_MOUVEMENT_STOCK";

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
  Response create(StockMovementCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface StockMovementSaveRequestDto {
    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link StockDto}.
     *
     * @return identifiant de {@link StockDto}
     */
    String getStockIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link StockDto}.
     *
     * @param stockIdentifier identifiant de {@link StockDto}
     */
    void setStockIdentifier(String stockIdentifier);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    String getReason();

    void setReason(String reason);

    String JSON_STOCK_IDENTIFIER = StockMovementDto.JSON_STOCK_IDENTIFIER;

    String JSON_QUANTITY = StockMovementDto.JSON_QUANTITY;

    String JSON_REASON = StockMovementDto.JSON_REASON;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockMovementCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements StockMovementSaveRequestDto {
    @JsonbProperty(JSON_STOCK_IDENTIFIER)
    private String stockIdentifier;

    @JsonbProperty(JSON_QUANTITY)
    private Integer quantity;

    @JsonbProperty(JSON_REASON)
    private String reason;
  }

  /**
   * Cette classe représente la réponse de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockMovementCreateResponseDto extends CreateResponseDto {

    @JsonbProperty(JSON_STOCK_QUANTITY_AS_STRING)
    String stockQuantityAsString;

    public static final String JSON_STOCK_QUANTITY_AS_STRING = StockDto.JSON_QUANTITY_AS_STRING;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_MOUVEMENT_STOCK";

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
  public static class StockMovementGetManyResponseDto
      extends AbstractGetByPageResponseDto<StockMovementDto> {

    @JsonbProperty(JSON_DATAS)
    private List<StockMovementDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_MOUVEMENT_STOCK";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_MOUVEMENT_STOCK";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_MOUVEMENT_STOCK";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(StockMovementUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockMovementUpdateRequestDto extends ByIdentifierRequestDto
      implements StockMovementSaveRequestDto {
    @JsonbProperty(JSON_STOCK_IDENTIFIER)
    private String stockIdentifier;

    @JsonbProperty(JSON_QUANTITY)
    private Integer quantity;

    @JsonbProperty(JSON_REASON)
    private String reason;
  }

  /**
   * Cette classe représente la réponse de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockMovementUpdateResponseDto extends IdentifiableResponseDto {

    @JsonbProperty(JSON_STOCK_QUANTITY_AS_STRING)
    String stockQuantityAsString;

    public static final String JSON_STOCK_QUANTITY_AS_STRING = StockDto.JSON_QUANTITY_AS_STRING;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_MOUVEMENT_STOCK";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);

  /**
   * Cette classe représente la réponse de suppression.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockMovementDeleteResponseDto extends IdentifiableResponseDto {

    @JsonbProperty(JSON_STOCK_QUANTITY_AS_STRING)
    String stockQuantityAsString;

    public static final String JSON_STOCK_QUANTITY_AS_STRING = StockDto.JSON_QUANTITY_AS_STRING;
  }
}
