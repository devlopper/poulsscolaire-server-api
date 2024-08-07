package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
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
 * Cette interface représente les services de {@link FeeDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = FeeService.PATH)
@Tag(name = "Gestion des frais")
public interface FeeService extends SpecificService {

  String PATH = "frais";

  String CREATE_IDENTIFIER = "CREATION_FRAIS";

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
  Response create(FeeCreateRequestDto request);

  /**
   * Cette interface représente la requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface FeeSaveRequestDto extends AmountService.AmountSaveRequestDto {
    String getCategoryIdentifier();

    void setCategoryIdentifier(String categoryIdentifier);

    String getAssignmentTypeIdentifier();

    void setAssignmentTypeIdentifier(String assignmentTypeIdentifier);

    String getSeniorityIdentifier();

    void setSeniorityIdentifier(String seniorityIdentifier);

    String getSchoolingIdentifier();

    void setSchoolingIdentifier(String schoolingIdentifier);

    String JSON_CATEGORY_IDENTIFIER = "idCategorie";
    String JSON_ASSIGNMENT_TYPE_IDENTIFIER = "idTypeAffectation";
    String JSON_SENIORITY_IDENTIFIER = "idAnciennete";
    String JSON_SCHOOLING_IDENTIFIER = "idScolarite";
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class FeeCreateRequestDto extends AmountService.AmountCreateRequestDto
      implements FeeSaveRequestDto {
    @JsonbProperty(JSON_CATEGORY_IDENTIFIER)
    private String categoryIdentifier;

    @JsonbProperty(JSON_ASSIGNMENT_TYPE_IDENTIFIER)
    private String assignmentTypeIdentifier;

    @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
    private String seniorityIdentifier;

    @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
    private String schoolingIdentifier;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_FRAIS";

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
  public static class FeeGetManyResponseDto extends AbstractGetByPageResponseDto<FeeDto> {

    @JsonbProperty(JSON_DATAS)
    private List<FeeDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_FRAIS";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER, description = "Ce service permet d'obtenir un frais")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_FRAIS";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant un frais")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_FRAIS";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour un frais")
  Response update(FeeUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class FeeUpdateRequestDto extends AmountService.AmountUpdateRequestDto
      implements FeeSaveRequestDto {
    @JsonbProperty(JSON_CATEGORY_IDENTIFIER)
    private String categoryIdentifier;

    @JsonbProperty(JSON_ASSIGNMENT_TYPE_IDENTIFIER)
    private String assignmentTypeIdentifier;

    @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
    private String seniorityIdentifier;

    @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
    private String schoolingIdentifier;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_FRAIS";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer un frais")
  Response delete(DeleteOneRequestDto request);
}
