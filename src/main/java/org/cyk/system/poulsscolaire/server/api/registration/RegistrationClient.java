package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.executor.CreateExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.GetOneExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.IdentifiableExecutor;
import ci.gouv.dgbf.extension.server.service.api.request.ByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.PageDto;
import ci.gouv.dgbf.extension.server.service.api.request.ProjectionDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import ci.gouv.dgbf.extension.server.service.api.segregation.DeleteByIdentifier;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetByIdentifier;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetMany;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cyk.system.poulsscolaire.server.api.registration.RegistrationService.RegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.RegistrationService.RegistrationGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.RegistrationService.RegistrationUpdateRequestDto;

/**
 * Cette classe représente un client de {@link RegistrationService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class RegistrationClient extends AbstractClient<RegistrationService>
    implements GetByIdentifier<RegistrationDto>, GetMany<RegistrationGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public RegistrationClient service(RegistrationService service) {
    return (RegistrationClient) super.service(service);
  }

  /**
   * {@link RegistrationService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(RegistrationCreateRequestDto request) {
    return new CreateExecutor(RegistrationService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link RegistrationService#create}.
   *
   * @param studentIdentifier identifiant élève
   * @param schoolingIdentifier identifiant scolarité
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public CreateResponseDto create(String studentIdentifier, String schoolingIdentifier,
      String assignmentTypeIdentifier, String seniorityIdenfier, String auditWho,
      String auditSession) {
    RegistrationCreateRequestDto request = new RegistrationCreateRequestDto();
    request.setStudentIdentifier(studentIdentifier);
    request.setSchoolingIdentifier(schoolingIdentifier);
    request.setAssignmnetTypeIdentifier(assignmentTypeIdentifier);
    request.setSeniorityIdentifier(seniorityIdenfier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return create(request);
  }

  public RegistrationGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<RegistrationGetManyResponseDto>(RegistrationGetManyResponseDto.class,
        RegistrationService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link RegistrationService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public RegistrationGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public RegistrationDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<RegistrationDto>(RegistrationDto.class,
        RegistrationService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link RegistrationService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public RegistrationDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link RegistrationService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public RegistrationDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<RegistrationDto>(RegistrationDto.class,
        RegistrationService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link RegistrationService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public RegistrationDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(RegistrationUpdateRequestDto request) {
    return new IdentifiableExecutor(RegistrationService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  /**
   * {@link RegistrationService#update}.
   *
   * @param identifier identifiant
   * @param studentIdentifier identifiant élève
   * @param schoolingIdentifier identifiant scolarité
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto update(String identifier, String studentIdentifier,
      String schoolingIdentifier, String assignmentTypeIdentifier, String seniorityIdenfier,
      String auditWho, String auditSession) {
    RegistrationUpdateRequestDto request = new RegistrationUpdateRequestDto();
    request.setIdentifier(identifier);
    request.setStudentIdentifier(studentIdentifier);
    request.setSchoolingIdentifier(schoolingIdentifier);
    request.setAssignmnetTypeIdentifier(assignmentTypeIdentifier);
    request.setSeniorityIdentifier(seniorityIdenfier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return update(request);
  }
  
  public IdentifiableResponseDto updateAmountsToZero(ByIdentifierRequestDto request) {
    return new IdentifiableExecutor(RegistrationService.UPDATE_AMOUNTS_TO_ZERO_IDENTIFIER)
        .execute(() -> service().updateAmountsToZero(request));
  }

  /**
   * {@link RegistrationService#updateAmountsToZero}.
   *
   * @param identifier identifiant
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto updateAmountsToZero(String identifier,
      String auditWho, String auditSession) {
    ByIdentifierRequestDto request = new ByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return updateAmountsToZero(request);
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(RegistrationService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link RegistrationService#delete}.
   *
   * @param identifier identifiant
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto deleteByIdentifier(String identifier, String auditWho,
      String auditSession) {
    DeleteOneRequestDto request = new DeleteOneRequestDto();
    request.setIdentifier(identifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return delete(request);
  }
}
