/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.core.eventhandler;

import org.axonframework.core.DomainEvent;

/**
 * Concurrency policy that requires sequential processing of events raised by the same aggregate. Events from different
 * aggregates may be processed in different threads.
 *
 * @author Allard Buijze
 * @since 0.3
 */
public class SequentialPerAggregatePolicy implements EventSequencingPolicy {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getSequenceIdentifierFor(DomainEvent event) {
        return event.getAggregateIdentifier();
    }
}