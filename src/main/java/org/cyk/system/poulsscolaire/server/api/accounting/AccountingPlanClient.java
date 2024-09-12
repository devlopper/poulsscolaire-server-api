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
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingPlanService.AccountingPlanCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingPlanService.AccountingPlanGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingPlanService.AccountingPlanUpdateRequestDto;

/**
 * Cette classe représente un client de {@link AccountingPlanService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class AccountingPlanClient extends AbstractClient<AccountingPlanService>
    implements GetByIdentifier<AccountingPlanDto>, GetMany<AccountingPlanGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public AccountingPlanClient service(AccountingPlanService service) {
    return (AccountingPlanClient) super.service(service);
  }

  /**
   * {@link AccountingPlanService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(AccountingPlanCreateRequestDto request) {
    return new CreateExecutor(AccountingPlanService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link AccountingPlanService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public AccountingPlanGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<AccountingPlanGetManyResponseDto>(
        AccountingPlanGetManyResponseDto.class, AccountingPlanService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link AccountingPlanService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public AccountingPlanGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public AccountingPlanDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<AccountingPlanDto>(AccountingPlanDto.class,
        AccountingPlanService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link AccountingPlanService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public AccountingPlanDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link AccountingPlanService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public AccountingPlanDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<AccountingPlanDto>(AccountingPlanDto.class,
        AccountingPlanService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link AccountingPlanService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public AccountingPlanDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(AccountingPlanUpdateRequestDto request) {
    return new IdentifiableExecutor(AccountingPlanService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(AccountingPlanService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link AccountingPlanService#delete}.
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
