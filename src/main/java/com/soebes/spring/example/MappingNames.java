package com.soebes.spring.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitJoinTableNameSource;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;


public class MappingNames extends SpringImplicitNamingStrategy {
  private static final Logger LOG = LogManager.getLogger(MappingNames.class);

  @Override
  public Identifier determineJoinTableName(ImplicitJoinTableNameSource source) {
    LOG.info("determineJoinTableName({})", source.getOwningEntityNaming());
    String name = source.getOwningPhysicalTableName() + "_"
                  + source.getAssociationOwningAttributePath().getProperty();
    return toIdentifier(name, source.getBuildingContext());
  }

}
