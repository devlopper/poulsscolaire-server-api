package org.cyk.system.poulsscolaire.server.api.accounting;

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
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingOperationService.AccountingOperationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingOperationService.AccountingOperationGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingOperationService.AccountingOperationUpdateRequestDto;

/**
 * Cette classe représente un client de {@link AccountingOperationService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class AccountingOperationClient extends AbstractClient<AccountingOperationService>
    implements GetByIdentifier<AccountingOperationDto>,
    GetMany<AccountingOperationGetManyResponseDto>, DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public AccountingOperationClient service(AccountingOperationService service) {
    return (AccountingOperationClient) super.service(service);
  }

  /**
   * {@link AccountingOperationService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(AccountingOperationCreateRequestDto request) {
    return new CreateExecutor(AccountingOperationService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link AccountingOperationService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public AccountingOperationGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<AccountingOperationGetManyResponseDto>(
        AccountingOperationGetManyResponseDto.class, AccountingOperationService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link AccountingOperationService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public AccountingOperationGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public AccountingOperationDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<AccountingOperationDto>(AccountingOperationDto.class,
        AccountingOperationService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link AccountingOperationService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public AccountingOperationDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link AccountingOperationService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public AccountingOperationDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<AccountingOperationDto>(AccountingOperationDto.class,
        AccountingOperationService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link AccountingOperationService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public AccountingOperationDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(AccountingOperationUpdateRequestDto request) {
    return new IdentifiableExecutor(AccountingOperationService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }
  
  public IdentifiableResponseDto cancel(ByIdentifierRequestDto request) {
    return new IdentifiableExecutor(AccountingOperationService.CANCEL_IDENTIFIER)
        .execute(() -> service().cancel(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(AccountingOperationService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link AccountingOperationService#delete}.
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
