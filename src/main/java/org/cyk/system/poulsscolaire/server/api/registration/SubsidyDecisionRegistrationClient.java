package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.executor.CreateExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.GetOneExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.IdentifiableExecutor;
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
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionRegistrationService.SubsidyDecisionRegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionRegistrationService.SubsidyDecisionRegistrationGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionRegistrationService.SubsidyDecisionRegistrationUpdateRequestDto;

/**
 * Cette classe représente un client de {@link SubsidyDecisionRegistrationService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class SubsidyDecisionRegistrationClient
    extends AbstractClient<SubsidyDecisionRegistrationService>
    implements GetByIdentifier<SubsidyDecisionRegistrationDto>,
    GetMany<SubsidyDecisionRegistrationGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public SubsidyDecisionRegistrationClient service(SubsidyDecisionRegistrationService service) {
    return (SubsidyDecisionRegistrationClient) super.service(service);
  }

  /**
   * {@link SubsidyDecisionRegistrationService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(SubsidyDecisionRegistrationCreateRequestDto request) {
    return new CreateExecutor(SubsidyDecisionRegistrationService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link SubsidyDecisionRegistrationService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public SubsidyDecisionRegistrationGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionRegistrationGetManyResponseDto>(
        SubsidyDecisionRegistrationGetManyResponseDto.class,
        SubsidyDecisionRegistrationService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link SubsidyDecisionRegistrationService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SubsidyDecisionRegistrationGetManyResponseDto getMany(ProjectionDto projection,
      FilterDto filter, PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  /**
   * {@link SubsidyDecisionRegistrationService#getOne}.
   *
   * @param request requête
   * @return réponse
   */
  public SubsidyDecisionRegistrationDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionRegistrationDto>(SubsidyDecisionRegistrationDto.class,
        SubsidyDecisionRegistrationService.GET_ONE_IDENTIFIER)
            .execute(() -> service().getOne(request));
  }

  /**
   * {@link SubsidyDecisionRegistrationService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SubsidyDecisionRegistrationDto getOne(ProjectionDto projection, FilterDto filter,
      String auditWho, String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link SubsidyDecisionRegistrationService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public SubsidyDecisionRegistrationDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionRegistrationDto>(SubsidyDecisionRegistrationDto.class,
        SubsidyDecisionRegistrationService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link SubsidyDecisionRegistrationService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public SubsidyDecisionRegistrationDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(SubsidyDecisionRegistrationUpdateRequestDto request) {
    return new IdentifiableExecutor(SubsidyDecisionRegistrationService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(SubsidyDecisionRegistrationService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link SubsidyDecisionRegistrationService#delete}.
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
