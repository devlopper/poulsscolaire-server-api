package org.cyk.system.poulsscolaire.server.api.registration;

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
 * Cette interface représente les services de {@link RegistrationDto}.
 *
 * @author Christian Yao Komenan
 *
 */
@Path(value = RegistrationService.PATH)
@Tag(name = "Gestion des inscriptions")
public interface RegistrationService extends SpecificService {

  String PATH = "inscriptions";

  String CREATE_IDENTIFIER = "CREATION_INSCRIPTION";

  String CREATE_PATH = "";

  /**
   * Cette méthode permet de créer une inscription.
   *
   * @param request requête
   * @return réponse
   */
  @Path(CREATE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(operationId = CREATE_IDENTIFIER, summary = "Création d'une inscription",
      description = "Ce service permet de créer une inscription")
  @APIResponse(responseCode = "201",
      content = {@Content(schema = @Schema(implementation = CreateResponseDto.class))})
  Response create(RegistrationCreateRequestDto request);

  /**
   * Cette classe représente la requête d'enregistrement.
   *
   * @author Christian
   *
   */
  interface RegistrationSaveRequestDto {
    String getStudentIdentifier();

    void setStudentIdentifier(String studentIdentifier);

    String getSchoolingIdentifier();

    void setSchoolingIdentifier(String schoolingIdentifier);

    String getAssignmentTypeIdentifier();

    void setAssignmentTypeIdentifier(String assignmentTypeIdentifier);

    String getSeniorityIdentifier();

    void setSeniorityIdentifier(String seniorityIdentifier);
    
    String getBranchInstanceIdentifier();

    void setBranchInstanceIdentifier(String branchInstanceIdentifier);

    int getPreRegistrationAmount();

    void setPreRegistrationAmount(int preRegistrationAmount);

    String JSON_STUDENT_IDENTIFIER = "idEleve";
    String JSON_SCHOOLING_IDENTIFIER = "idScolarite";
    String JSON_ASSIGNMENT_TYPE_IDENTIFIER = "idTypeAffectation";
    String JSON_SENIORITY_IDENTIFIER = "idAnciennete";
    String JSON_BRANCH_INSTANCE_IDENTIFIER = "idClasse";
    String JSON_PRE_REGISTRATION_AMOUNT = "montantPreInscription";
  }

  /**
   * Cette classe représente la requête de création.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class RegistrationCreateRequestDto extends AbstractAuditedRequestJsonDto
      implements RegistrationSaveRequestDto {
    @JsonbProperty(JSON_STUDENT_IDENTIFIER)
    private String studentIdentifier;

    @JsonbProperty(JSON_ASSIGNMENT_TYPE_IDENTIFIER)
    private String assignmentTypeIdentifier;

    @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
    private String seniorityIdentifier;

    @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
    private String schoolingIdentifier;
    
    @JsonbProperty(JSON_BRANCH_INSTANCE_IDENTIFIER)
    private String branchInstanceIdentifier;
    
    @JsonbProperty(JSON_SCHOOLING_2_IDENTIFIER)
    private String schooling2Identifier;
    
    @JsonbProperty(JSON_BRANCH_INSTANCE_2_IDENTIFIER)
    private String branchInstance2Identifier;
    
    @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT)
    private int preRegistrationAmount;
    
    public static final String JSON_SCHOOLING_2_IDENTIFIER = "idScolarite2";
    public static final String JSON_BRANCH_INSTANCE_2_IDENTIFIER = "idClasse2";
  }

  String GET_MANY_IDENTIFIER = "OBTENTION_PLUSIEURS_INSCRIPTION";

  String GET_MANY_PATH = "obtention/plusieurs";

  @Path(GET_MANY_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_MANY_IDENTIFIER,
      description = "Ce service permet d'obtenir des inscriptions")
  Response getMany(GetManyRequestDto request);

  /**
   * Cette classe représente l'objet de transfert de donnée de la réponse d'obtention de plusieurs.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  public static class RegistrationGetManyResponseDto
      extends AbstractGetByPageResponseDto<RegistrationDto> {

    @JsonbProperty(JSON_DATAS)
    private List<RegistrationDto> datas;
  }

  String GET_ONE_IDENTIFIER = "OBTENTION_UN_INSCRIPTION";

  String GET_ONE_PATH = "obtention/un";

  @Path(GET_ONE_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_ONE_IDENTIFIER,
      description = "Ce service permet d'obtenir une inscription")
  Response getOne(GetOneRequestDto request);

  String GET_BY_IDENTIFIER_IDENTIFIER = "OBTENTION_PAR_IDENTIFIANT_INSCRIPTION";

  String GET_BY_IDENTIFIER_PATH = "obtention/par-identifiant";

  @Path(GET_BY_IDENTIFIER_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON})
  @Operation(operationId = GET_BY_IDENTIFIER_IDENTIFIER,
      description = "Ce service permet d'obtenir par identifiant une inscription")
  Response getByIdentifier(GetByIdentifierRequestDto request);

  String UPDATE_IDENTIFIER = "MISE_A_JOUR_INSCRIPTION";

  String UPDATE_PATH = "";

  @Path(UPDATE_PATH)
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_IDENTIFIER,
      description = "Ce service permet de mettre à jour une inscription")
  Response update(RegistrationUpdateRequestDto request);

  String UPDATE_AMOUNTS_TO_ZERO_IDENTIFIER = "MISE_A_JOUR_MONTANTS_A_ZERO_INSCRIPTION";

  String UPDATE_AMOUNTS_TO_ZERO_PATH = "montants-a-zero";

  @Path(UPDATE_AMOUNTS_TO_ZERO_PATH)
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = UPDATE_AMOUNTS_TO_ZERO_IDENTIFIER,
      description = "Ce service permet de mettre à jour les montants à zéro d'une inscription")
  Response updateAmountsToZero(ByIdentifierRequestDto request);

  /**
   * Cette classe représente la requête de mise à jour.
   *
   * @author Christian
   *
   */
  @Getter
  @Setter
  class RegistrationUpdateRequestDto extends ByIdentifierRequestDto
      implements RegistrationSaveRequestDto {
    @JsonbProperty(JSON_STUDENT_IDENTIFIER)
    private String studentIdentifier;

    @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
    private String schoolingIdentifier;

    @JsonbProperty(JSON_ASSIGNMENT_TYPE_IDENTIFIER)
    private String assignmentTypeIdentifier;

    @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
    private String seniorityIdentifier;

    @JsonbProperty(JSON_BRANCH_INSTANCE_IDENTIFIER)
    private String branchInstanceIdentifier;
    
    @JsonbProperty(JSON_PRE_REGISTRATION_AMOUNT)
    private int preRegistrationAmount;
  }

  String DELETE_IDENTIFIER = "SUPPRESSION_INSCRIPTION";

  String DELETE_PATH = "";

  @Path(DELETE_PATH)
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Operation(operationId = DELETE_IDENTIFIER,
      description = "Ce service permet de supprimer une inscription")
  Response delete(DeleteOneRequestDto request);
}
