package com.soebes.spring.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;


public class MappingNames extends PhysicalNamingStrategyStandardImpl {
  private static final Logger LOG = LogManager.getLogger(MappingNames.class);

  @Override
  public Identifier toPhysicalCatalogName(Identifier logicalName, JdbcEnvironment context) {
    LOG.info("toPhysicalCatalogName({})", logicalName);
    return logicalName;
  }

  @Override
  public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment context) {
    LOG.info("toPhysicalSchemaName({})", logicalName);
    return super.toPhysicalSchemaName(logicalName, context);
  }

  @Override
  public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
    LOG.info("toPhysicalTableName({})", logicalName);
    return super.toPhysicalTableName(logicalName, context);
  }

  @Override
  public Identifier toPhysicalSequenceName(Identifier logicalName, JdbcEnvironment context) {
    LOG.info("toPhysicalSequenceName({})", logicalName);
    return super.toPhysicalSequenceName(logicalName, context);
  }

  @Override
  public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment context) {
    LOG.info("toPhysicalColumnName({})", logicalName);
    return super.toPhysicalColumnName(logicalName, context);
  }

}
