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
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountOperationService.AccountingAccountOperationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountOperationService.AccountingAccountOperationGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountOperationService.AccountingAccountOperationUpdateRequestDto;

/**
 * Cette classe représente un client de {@link AccountingAccountOperationService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class AccountingAccountOperationClient
    extends AbstractClient<AccountingAccountOperationService>
    implements GetByIdentifier<AccountingAccountOperationDto>,
    GetMany<AccountingAccountOperationGetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public AccountingAccountOperationClient service(AccountingAccountOperationService service) {
    return (AccountingAccountOperationClient) super.service(service);
  }

  /**
   * {@link AccountingAccountOperationService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(AccountingAccountOperationCreateRequestDto request) {
    return new CreateExecutor(AccountingAccountOperationService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link AccountingAccountOperationService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public AccountingAccountOperationGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<AccountingAccountOperationGetManyResponseDto>(
        AccountingAccountOperationGetManyResponseDto.class,
        AccountingAccountOperationService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link AccountingAccountOperationService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public AccountingAccountOperationGetManyResponseDto getMany(ProjectionDto projection,
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
   * {@link AccountingAccountOperationService#getOne}.
   *
   * @param request requête
   * @return réponse
   */
  public AccountingAccountOperationDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<AccountingAccountOperationDto>(AccountingAccountOperationDto.class,
        AccountingAccountOperationService.GET_ONE_IDENTIFIER)
            .execute(() -> service().getOne(request));
  }

  /**
   * {@link AccountingAccountOperationService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public AccountingAccountOperationDto getOne(ProjectionDto projection, FilterDto filter,
      String auditWho, String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link AccountingAccountOperationService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public AccountingAccountOperationDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<AccountingAccountOperationDto>(AccountingAccountOperationDto.class,
        AccountingAccountOperationService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link AccountingAccountOperationService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public AccountingAccountOperationDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(AccountingAccountOperationUpdateRequestDto request) {
    return new IdentifiableExecutor(AccountingAccountOperationService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(AccountingAccountOperationService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link AccountingAccountOperationService#delete}.
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
