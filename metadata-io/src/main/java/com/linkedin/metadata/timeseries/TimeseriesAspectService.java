package com.linkedin.metadata.timeseries;

import com.fasterxml.jackson.databind.JsonNode;
import com.linkedin.common.urn.Urn;
import com.linkedin.metadata.aspect.EnvelopedAspect;
import com.linkedin.metadata.query.filter.Filter;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.linkedin.timeseries.GroupingBucket;
import com.linkedin.timeseries.GenericTable;
import com.linkedin.timeseries.AggregationSpec;


public interface TimeseriesAspectService {

  void configure();

  void upsertDocument(@Nonnull String entityName, @Nonnull String aspectName, @Nonnull String docId, @Nonnull JsonNode document);

  List<EnvelopedAspect> getAspectValues(@Nonnull final Urn urn, @Nonnull String entityName, @Nonnull String aspectName,
      @Nullable Long startTimeMillis, Long endTimeMillis, int limit);

  /**
   * Get the aggregated metrics for the given dataset or column from a time series aspect.
   */
  @Nonnull
  GenericTable getAggregatedStats(@Nonnull String entityName, @Nonnull String aspectName, @Nonnull AggregationSpec[] aggregationSpecs,
      @Nullable Filter filter, @Nullable GroupingBucket[] groupingBuckets);
}
