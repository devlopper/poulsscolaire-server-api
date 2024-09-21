package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un plan comptable.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AccountingPlanDto extends AbstractIdentifiableCodableNamableAuditableDto {
  
  public static final String NAME = "plan comptable";
  
  public static final String PLURAL_NAME = "plans comptables";
}
