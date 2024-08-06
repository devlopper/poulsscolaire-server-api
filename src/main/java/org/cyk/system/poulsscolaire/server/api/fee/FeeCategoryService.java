package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableNamableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableNamableUpdateRequestJsonDto;
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
 * Cette interface représente les services de {@link FeeCategoryDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = FeeCategoryService.PATH)
@Tag(name = "Gestion des rubriques")
public interface FeeCategoryService extends SpecificService {

  String PATH = "rubriques";

  String CREATE_IDENTIFIER = "CREATION_RUBRIQUE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une rubrique.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une rubrique",
      description = "Ce service permet de créer une rubrique")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(FeeCategoryCreateRequestDto request);

  /**
   * Cette interface représente la requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface FeeCategorySaveRequest {
    String getSchoolIdentifier();

    void setSchoolIdentifier(String schoolIdentifier);

    String JSON_SCHOOL_IDENTIFIER = "idEcole";
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class FeeCategoryCreateRequestDto extends AbstractCodableNamableCreateRequestJsonDto
      implements FeeCategorySaveRequest {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_RUBRIQUE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des rubriques")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class FeeCategoryGetManyResponseDto
      extends AbstractGetByPageResponseDto<FeeCategoryDto> {

    @JsonbProperty(JSON_DATAS)
    private List<FeeCategoryDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_RUBRIQUE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une rubrique")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_RUBRIQUE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une rubrique")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_RUBRIQUE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une rubrique")
  Response update(FeeCategoryUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class FeeCategoryUpdateRequestDto extends AbstractCodableNamableUpdateRequestJsonDto
      implements FeeCategorySaveRequest {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_RUBRIQUE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une rubrique")
  Response delete(DeleteOneRequestDto request);
}
