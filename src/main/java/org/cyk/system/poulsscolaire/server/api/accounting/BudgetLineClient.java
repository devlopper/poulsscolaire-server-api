package org.cyk.system.poulsscolaire.server.api.accounting;

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
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetLineService.BudgetLineCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetLineService.BudgetLineGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetLineService.BudgetLineUpdateRequestDto;

/**
 * Cette classe représente un client de {@link BudgetLineService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class BudgetLineClient extends AbstractClient<BudgetLineService>
    implements GetByIdentifier<BudgetLineDto>,
    GetMany<BudgetLineGetManyResponseDto>, DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public BudgetLineClient service(BudgetLineService service) {
    return (BudgetLineClient) super.service(service);
  }

  /**
   * {@link BudgetLineService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(BudgetLineCreateRequestDto request) {
    return new CreateExecutor(BudgetLineService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link BudgetLineService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public BudgetLineGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<BudgetLineGetManyResponseDto>(
        BudgetLineGetManyResponseDto.class, BudgetLineService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link BudgetLineService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public BudgetLineGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public BudgetLineDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<BudgetLineDto>(BudgetLineDto.class,
        BudgetLineService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link BudgetLineService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public BudgetLineDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link BudgetLineService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public BudgetLineDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<BudgetLineDto>(BudgetLineDto.class,
        BudgetLineService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link BudgetLineService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public BudgetLineDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(BudgetLineUpdateRequestDto request) {
    return new IdentifiableExecutor(BudgetLineService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }
  
  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(BudgetLineService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link BudgetLineService#delete}.
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
