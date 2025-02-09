package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableUpdateRequestJsonDto;
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
 * Cette interface représente les services de {@link SubsidyDecisionDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = SubsidyDecisionService.PATH)
@Tag(name = "Gestion des décisions de subvention")
public interface SubsidyDecisionService extends SpecificService {

  String PATH = "decisions-subventions";

  String CREATE_IDENTIFIER = "CREATION_DECISION_SUBVENTION";

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
  Response create(SubsidyDecisionCreateRequestDto request);

  /**
   * Cette interface représente une reuqête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface SubsidyDecisionSaveRequest {
    String getSchoolingIdentifier();

    void setSchoolingIdentifier(String schoolingIdentifier);

    int getAmount();

    void setAmount(int amount);

    String JSON_SCHOOLING_IDENTIFIER = SubsidyDecisionDto.JSON_SCHOOLING_IDENTIFIER;
    String JSON_AMOUNT = SubsidyDecisionDto.JSON_AMOUNT;
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SubsidyDecisionCreateRequestDto extends AbstractCodableCreateRequestJsonDto
      implements SubsidyDecisionSaveRequest {
    @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
    private String schoolingIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_DECISION_SUBVENTION";

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
  public static class SubsidyDecisionGetManyResponseDto
      extends AbstractGetByPageResponseDto<SubsidyDecisionDto> {

    @JsonbProperty(JSON_DATAS)
    private List<SubsidyDecisionDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_DECISION_SUBVENTION";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER)
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_DECISION_SUBVENTION";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER)
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_DECISION_SUBVENTION";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER)
  Response update(SubsidyDecisionUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class SubsidyDecisionUpdateRequestDto extends AbstractCodableUpdateRequestJsonDto
      implements SubsidyDecisionSaveRequest {
    @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
    private String schoolingIdentifier;

    @JsonbProperty(JSON_AMOUNT)
    private int amount;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_DECISION_SUBVENTION";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER)
  Response delete(DeleteOneRequestDto request);
}
