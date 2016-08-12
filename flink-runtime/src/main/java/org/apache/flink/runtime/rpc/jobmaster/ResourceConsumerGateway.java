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
package org.apache.flink.runtime.rpc.jobmaster;

import org.apache.flink.runtime.instance.Slot;
import org.apache.flink.runtime.messages.Acknowledge;
import org.apache.flink.runtime.rpc.RpcGateway;
import scala.concurrent.Future;

public interface ResourceConsumerGateway extends RpcGateway {
	/**
	 *  handle slot failure caused by task manager lost
	 * @param slot
	 */
	void notifySlotFailure(Slot slot);

	/**
	 * handle slot available notified from task manager
	 * @param slot
	 * @return Future acknowledge of the slot notification
	 */
	Future<Acknowledge> notifySlotAvailable(Slot slot);
}
