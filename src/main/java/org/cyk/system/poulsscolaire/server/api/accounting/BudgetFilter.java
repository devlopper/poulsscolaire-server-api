package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.DepartmentDto;

/**
 * Cette classe représente le filtre de {@link BudgetDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class BudgetFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;

  String departmentIdentifier;
  
  public BudgetFilter(FilterDto dto) {
    super(dto);
  }

  public BudgetFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    departmentIdentifier = getDepartmentIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setDepartmentIdentifier(filter, departmentIdentifier);
  }
  
  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setDepartmentIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_DEPARTMENT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getDepartmentIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_DEPARTMENT_IDENTIFIER));
  }
  
  public static final String JSON_SCHOOL_IDENTIFIER = BudgetDto.JSON_SCHOOL_IDENTIFIER; 
  
  public static final String JSON_DEPARTMENT_IDENTIFIER = DepartmentDto.JSON_THIS_IDENTIFIER;
}