package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingOperationAccountDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingOperationAccountFilter extends AbstractIdentifiableFilter {
  public AccountingOperationAccountFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingOperationAccountFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
  }
}
