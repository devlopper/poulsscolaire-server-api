package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingAccountOperationDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingAccountOperationFilter extends AbstractIdentifiableFilter {
  public AccountingAccountOperationFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingAccountOperationFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
  }
}
