package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.core.segregation.HasFeeCategoryIdentifierDto;
import ci.gouv.dgbf.extension.core.segregation.HasStockIdentifierDto;
import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractNamableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractNamableUpdateRequestJsonDto;
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
 * Cette interface représente les services de {@link StockFeeCategoryDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = StockFeeCategoryService.PATH)
@Tag(name = "Gestion des stocks de catégorie de frais")
public interface StockFeeCategoryService extends SpecificService {

  String PATH = "stocks-categories-frais";

  String CREATE_IDENTIFIER = "CREATION_STOCK_CATEGORIE_FRAIS";

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
  Response create(StockFeeCategoryCreateRequestDto request);

  /**
   * Cette classe représente une requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface StockFeeCategoryServiceSaveRequestDto {
    /**
     * Cette méthode permet d'obtenir de {@link StockDto}.
     *
     * @return de {@link StockDto}
     */
    String getStockIdentifier();

    /**
     * Cette méthode permet d'assigner de {@link StockDto}.
     *
     * @param stockIdentifier de {@link StockDto}
     */
    void setStockIdentifier(String stockIdentifier);

    /**
     * Cette méthode permet d'obtenir l'identifiant de {@link FeeCategoryDto}.
     *
     * @return identifiant de {@link FeeCategoryDto}
     */
    String getFeeCategoryIdentifier();

    /**
     * Cette méthode permet d'assigner l'identifiant de {@link FeeCategoryDto}.
     *
     * @param feeCategoryIdentifier identifiant de {@link FeeCategoryDto}
     */
    void setFeeCategoryIdentifier(String feeCategoryIdentifier);

    String JSON_STOCK_IDENTIFIER = HasStockIdentifierDto.JSON_STOCK_IDENTIFIER;

    String JSON_FEE_CATEGORY_IDENTIFIER = HasFeeCategoryIdentifierDto.JSON_FEE_CATEGORY_IDENTIFIER;

  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockFeeCategoryCreateRequestDto extends AbstractNamableCreateRequestJsonDto
      implements StockFeeCategoryServiceSaveRequestDto {

    @JsonbProperty(JSON_STOCK_IDENTIFIER)
    private String stockIdentifier;

    @JsonbProperty(JSON_FEE_CATEGORY_IDENTIFIER)
    private String feeCategoryIdentifier;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_STOCK_CATEGORIE_FRAIS";

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
  public static class StockFeeCategoryGetManyResponseDto
      extends AbstractGetByPageResponseDto<StockFeeCategoryDto> {

    @JsonbProperty(JSON_DATAS)
    private List<StockFeeCategoryDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_STOCK_CATEGORIE_FRAIS";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_STOCK_CATEGORIE_FRAIS";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_STOCK_CATEGORIE_FRAIS";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(StockFeeCategoryUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockFeeCategoryUpdateRequestDto extends AbstractNamableUpdateRequestJsonDto
      implements StockFeeCategoryServiceSaveRequestDto {

    @JsonbProperty(JSON_STOCK_IDENTIFIER)
    private String stockIdentifier;

    @JsonbProperty(JSON_FEE_CATEGORY_IDENTIFIER)
    private String feeCategoryIdentifier;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_STOCK_CATEGORIE_FRAIS";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);
}
