package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.SpecificService;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractAuditedRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableNamableCreateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableNamableUpdateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractCodableUpdateRequestJsonDto;
import ci.gouv.dgbf.extension.server.service.api.request.AbstractRequestDto;
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
 * Cette interface représente les services de {@link BranchDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = BranchService.PATH)
@Tag(name = "Gestion des branches")
public interface BranchService extends SpecificService {

  String PATH = "branches";

  String CREATE_IDENTIFIER = "CREATION_BRANCHE";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une branche.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une branche",
      description = "Ce service permet de créer une branche")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(BranchCreateRequestDto request);

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {AbstractCodableCreateRequestJsonDto.FIELD_CODE,
      AbstractCodableNamableCreateRequestJsonDto.FIELD_NAME,
      BranchCreateRequestDto.FIELD_SCHOOL_IDENTIFIER,
      BranchCreateRequestDto.FIELD_PERIOD_IDENTIFIER, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class BranchCreateRequestDto extends AbstractCodableNamableCreateRequestJsonDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_PERIOD_IDENTIFIER)
    private String periodIdentifier;

    public static final String FIELD_SCHOOL_IDENTIFIER = "schoolIdentifier";
    public static final String FIELD_PERIOD_IDENTIFIER = "periodIdentifier";

    public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
    public static final String JSON_PERIOD_IDENTIFIER = "idPeriod";
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_BRANCHE";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des branches")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class GetManyResponseDto extends AbstractGetByPageResponseDto<BranchDto> {

    @JsonbProperty(JSON_DATAS)
    private List<BranchDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_BRANCHE";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une branche")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_BRANCHE";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une branche")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_BRANCHE";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une branche")
  Response update(BranchUpdateRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  @JsonbPropertyOrder(value = {AbstractCodableUpdateRequestJsonDto.FIELD_CODE,
      AbstractCodableNamableUpdateRequestJsonDto.FIELD_NAME,
      BranchUpdateRequestDto.FIELD_SCHOOL_IDENTIFIER,
      BranchUpdateRequestDto.FIELD_PERIOD_IDENTIFIER, AbstractRequestDto.FIELD_AUDIT_WHO,
      AbstractAuditedRequestJsonDto.FIELD_AUDIT_SESSION})
  class BranchUpdateRequestDto extends AbstractCodableNamableUpdateRequestJsonDto {
    @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
    private String schoolIdentifier;

    @JsonbProperty(JSON_PERIOD_IDENTIFIER)
    private String periodIdentifier;

    public static final String FIELD_SCHOOL_IDENTIFIER = "schoolIdentifier";
    public static final String FIELD_PERIOD_IDENTIFIER = "periodIdentifier";

    public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
    public static final String JSON_PERIOD_IDENTIFIER = "idPeriod";
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_BRANCHE";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une branche")
  Response delete(DeleteOneRequestDto request);
}
