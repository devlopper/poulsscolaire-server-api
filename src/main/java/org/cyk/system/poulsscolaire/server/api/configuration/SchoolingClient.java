package org.cyk.system.poulsscolaire.server.api.configuration;

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
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingService.GetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingService.SchoolingCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingService.SchoolingGenerateRequestDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingService.SchoolingGenerateResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingService.SchoolingUpdateRequestDto;

/**
 * Cette classe représente un client de {@link SchoolingService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class SchoolingClient extends AbstractClient<SchoolingService>
    implements GetByIdentifier<SchoolingDto>, GetMany<GetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public SchoolingClient service(SchoolingService service) {
    return (SchoolingClient) super.service(service);
  }

  /**
   * {@link SchoolingService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(SchoolingCreateRequestDto request) {
    return new CreateExecutor(SchoolingService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link SchoolingService#create}.
   *
   * @param schoolIdentifier identifiant école
   * @param branchIdentifier identifiant branche
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public CreateResponseDto create(String schoolIdentifier, String branchIdentifier,
      String periodIdentifier, String auditWho, String auditSession) {
    SchoolingCreateRequestDto request = new SchoolingCreateRequestDto();
    request.setSchoolIdentifier(schoolIdentifier);
    request.setBranchIdentifier(branchIdentifier);
    request.setPeriodIdentifier(periodIdentifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return create(request);
  }

  public SchoolingGenerateResponseDto generate(SchoolingGenerateRequestDto request) {
    return new GetOneExecutor<SchoolingGenerateResponseDto>(SchoolingGenerateResponseDto.class,
        SchoolingService.GENERATE_IDENTIFIER).execute(() -> service().generate(request));
  }

  /**
   * {@link SchoolingService#generate}.
   *
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SchoolingGenerateResponseDto generate(String auditWho, String auditSession) {
    SchoolingGenerateRequestDto request = new SchoolingGenerateRequestDto();
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return generate(request);
  }

  public GetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<GetManyResponseDto>(GetManyResponseDto.class,
        SchoolingService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link SchoolingService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public GetManyResponseDto getMany(ProjectionDto projection, FilterDto filter, PageDto page,
      String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public SchoolingDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<SchoolingDto>(SchoolingDto.class, SchoolingService.GET_ONE_IDENTIFIER)
        .execute(() -> service().getOne(request));
  }

  /**
   * {@link SchoolingService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SchoolingDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link SchoolingService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public SchoolingDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<SchoolingDto>(SchoolingDto.class,
        SchoolingService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * Cette méthode permet d'obtenir par identifiant un groupe d'échéance.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public SchoolingDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(SchoolingUpdateRequestDto request) {
    return new IdentifiableExecutor(SchoolingService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  /**
   * {@link SchoolingService#update}.
   *
   * @param identifier identifiant
   * @param schoolIdentifier identifiant école
   * @param branchIdentifier identifiant branche
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto update(String identifier, String schoolIdentifier,
      String branchIdentifier, String periodIdentifier, String auditWho, String auditSession) {
    SchoolingUpdateRequestDto request = new SchoolingUpdateRequestDto();
    request.setIdentifier(identifier);
    request.setSchoolIdentifier(schoolIdentifier);
    request.setBranchIdentifier(branchIdentifier);
    request.setPeriodIdentifier(periodIdentifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return update(request);
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(SchoolingService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link SchoolingService#delete}.
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
