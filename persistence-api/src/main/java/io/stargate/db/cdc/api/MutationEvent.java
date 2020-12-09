/*
 * Copyright The Stargate Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.stargate.db.cdc.api;

import io.stargate.db.schema.Table;
import java.util.List;
import java.util.OptionalInt;
import java.util.OptionalLong;

/** Represents a change made in the database. */
public interface MutationEvent {
  /** Gets the table metadata at the time of the event. */
  Table table();

  OptionalInt ttl();

  OptionalLong timestamp();

  /** Gets the partitions keys of this event */
  List<CellValue> getPartitionKeys();

  /** Gets the clustering keys of this event */
  List<Cell> getClusteringKeys();

  /** It will be non empty for {@link MutationEventType#UPDATE} */
  List<Cell> getCells();

  MutationEventType mutationEventType();
}
