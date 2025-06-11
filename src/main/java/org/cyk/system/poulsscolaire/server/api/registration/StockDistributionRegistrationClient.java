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
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionRegistrationService.StockDistributionRegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionRegistrationService.StockDistributionRegistrationGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionRegistrationService.StockDistributionRegistrationUpdateRequestDto;

/**
 * Cette classe représente un client de {@link StockDistributionRegistrationService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class StockDistributionRegistrationClient
    extends AbstractClient<StockDistributionRegistrationService>
    implements GetByIdentifier<StockDistributionRegistrationDto>,
    GetMany<StockDistributionRegistrationGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public StockDistributionRegistrationClient service(StockDistributionRegistrationService service) {
    return (StockDistributionRegistrationClient) super.service(service);
  }

  /**
   * {@link StockDistributionRegistrationService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(StockDistributionRegistrationCreateRequestDto request) {
    return new CreateExecutor(StockDistributionRegistrationService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link StockDistributionRegistrationService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public StockDistributionRegistrationGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<StockDistributionRegistrationGetManyResponseDto>(
        StockDistributionRegistrationGetManyResponseDto.class,
        StockDistributionRegistrationService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link StockDistributionRegistrationService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public StockDistributionRegistrationGetManyResponseDto getMany(ProjectionDto projection,
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
   * {@link StockDistributionRegistrationService#getOne}.
   *
   * @param request requête
   * @return réponse
   */
  public StockDistributionRegistrationDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<StockDistributionRegistrationDto>(
        StockDistributionRegistrationDto.class,
        StockDistributionRegistrationService.GET_ONE_IDENTIFIER)
            .execute(() -> service().getOne(request));
  }

  /**
   * {@link StockDistributionRegistrationService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public StockDistributionRegistrationDto getOne(ProjectionDto projection, FilterDto filter,
      String auditWho, String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link StockDistributionRegistrationService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public StockDistributionRegistrationDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<StockDistributionRegistrationDto>(
        StockDistributionRegistrationDto.class,
        StockDistributionRegistrationService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link StockDistributionRegistrationService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public StockDistributionRegistrationDto getByIdentifier(String identifier,
      ProjectionDto projection, String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(StockDistributionRegistrationUpdateRequestDto request) {
    return new IdentifiableExecutor(StockDistributionRegistrationService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(StockDistributionRegistrationService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link StockDistributionRegistrationService#delete}.
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
