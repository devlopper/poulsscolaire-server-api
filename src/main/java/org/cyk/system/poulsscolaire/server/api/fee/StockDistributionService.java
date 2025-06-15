package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.core.segregation.HasDateDto;
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
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.BranchInstanceDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Cette interface représente les services de {@link StockDistributionDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = StockDistributionService.PATH)
@Tag(name = "Gestion des distributions de stock")
public interface StockDistributionService extends SpecificService {

  String PATH = "distributions-stock";

  String CREATE_IDENTIFIER = "CREATION_DISTRIBUTION_STOCK";

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
  Response create(StockDistributionCreateRequestDto request);

  /**
   * Cette interface représente une reuqête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface StockDistributionSaveRequest {
    String getStockIdentifier();

    void setStockIdentifier(String stockIdentifier);

    String getBranchInstanceIdentifier();

    void setBranchInstanceIdentifier(String branchInstanceIdentifier);

    LocalDateTime getDate();

    void setDate(LocalDateTime date);

    String JSON_STOCK_IDENTIFIER = StockDto.JSON_THIS_IDENTIFIER;
    String JSON_BRANCH_INSTANCE_IDENTIFIER = BranchInstanceDto.JSON_THIS_IDENTIFIER;
    String JSON_DATE = HasDateDto.JSON_DATE;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockDistributionCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements StockDistributionSaveRequest {
    @JsonbProperty(JSON_STOCK_IDENTIFIER)
    private String stockIdentifier;

    @JsonbProperty(JSON_BRANCH_INSTANCE_IDENTIFIER)
    private String branchInstanceIdentifier;

    @JsonbProperty(JSON_DATE)
    private LocalDateTime date;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_DISTRIBUTION_STOCK";

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
  public static class StockDistributionGetManyResponseDto
      extends AbstractGetByPageResponseDto<StockDistributionDto> {

    @JsonbProperty(JSON_DATAS)
    private List<StockDistributionDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_DISTRIBUTION_STOCK";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_DISTRIBUTION_STOCK";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_DISTRIBUTION_STOCK";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(StockDistributionUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class StockDistributionUpdateRequestDto extends ByIdentifierRequestDto
      implements StockDistributionSaveRequest {
    @JsonbProperty(JSON_STOCK_IDENTIFIER)
    private String stockIdentifier;

    @JsonbProperty(JSON_BRANCH_INSTANCE_IDENTIFIER)
    private String branchInstanceIdentifier;

    @JsonbProperty(JSON_DATE)
    private LocalDateTime date;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_DISTRIBUTION_STOCK";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);
}
