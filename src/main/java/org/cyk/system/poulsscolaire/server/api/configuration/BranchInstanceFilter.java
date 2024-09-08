package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link BranchDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class BranchInstanceFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  String branchIdentifier;
  String schoolingIdentifier;

  public BranchInstanceFilter(FilterDto dto) {
    super(dto);
  }

  public BranchInstanceFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    branchIdentifier = getBranchIdentifier(filter);
    schoolingIdentifier = getSchoolingIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setBranchIdentifier(filter, branchIdentifier);
    setSchoolingIdentifier(filter, schoolingIdentifier);
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setBranchIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BRANCH_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBranchIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BRANCH_IDENTIFIER));
  }

  public static void setSchoolingIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOLING_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolingIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOLING_IDENTIFIER));
  }

  public static final String JSON_SCHOOL_IDENTIFIER = BranchInstanceDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_BRANCH_IDENTIFIER = BranchInstanceDto.JSON_BRANCH_IDENTIFIER;
  public static final String JSON_SCHOOLING_IDENTIFIER = "idScolarite";
}
