/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.stargate.transport;

import org.apache.cassandra.stargate.exceptions.ExceptionCode;
import org.apache.cassandra.stargate.exceptions.PersistenceException;

/** Exceptions thrown when a client didn't respect the protocol. */
public class ProtocolException extends PersistenceException {
  private final ProtocolVersion forcedProtocolVersion;

  public ProtocolException(String msg) {
    this(msg, null);
  }

  public ProtocolException(String msg, ProtocolVersion forcedProtocolVersion) {
    super(ExceptionCode.PROTOCOL_ERROR, msg);
    this.forcedProtocolVersion = forcedProtocolVersion;
  }

  public ProtocolVersion getForcedProtocolVersion() {
    return forcedProtocolVersion;
  }
}
