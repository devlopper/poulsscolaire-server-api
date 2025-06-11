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
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionService.StockDistributionCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionService.StockDistributionGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionService.StockDistributionUpdateRequestDto;

/**
 * Cette classe représente un client de {@link StockDistributionService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class StockDistributionClient extends AbstractClient<StockDistributionService>
    implements GetByIdentifier<StockDistributionDto>, GetMany<StockDistributionGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public StockDistributionClient service(StockDistributionService service) {
    return (StockDistributionClient) super.service(service);
  }

  /**
   * {@link StockDistributionService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(StockDistributionCreateRequestDto request) {
    return new CreateExecutor(StockDistributionService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link StockDistributionService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public StockDistributionGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<StockDistributionGetManyResponseDto>(
        StockDistributionGetManyResponseDto.class, StockDistributionService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link StockDistributionService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public StockDistributionGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public StockDistributionDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<StockDistributionDto>(StockDistributionDto.class,
        StockDistributionService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link StockDistributionService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public StockDistributionDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link StockDistributionService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public StockDistributionDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<StockDistributionDto>(StockDistributionDto.class,
        StockDistributionService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link StockDistributionService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public StockDistributionDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(StockDistributionUpdateRequestDto request) {
    return new IdentifiableExecutor(StockDistributionService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(StockDistributionService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link StockDistributionService#delete}.
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
