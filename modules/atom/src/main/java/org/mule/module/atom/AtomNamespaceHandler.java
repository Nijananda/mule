/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.atom;

import org.mule.config.spring.parsers.generic.ChildDefinitionParser;
import org.mule.config.spring.parsers.specific.ComponentDefinitionParser;
import org.mule.config.spring.parsers.specific.MessageProcessorDefinitionParser;
import org.mule.config.spring.parsers.specific.RouterDefinitionParser;
import org.mule.config.spring.parsers.specific.endpoint.TransportEndpointDefinitionParser;
import org.mule.expression.transformers.ExpressionArgument;
import org.mule.module.atom.endpoint.AtomInboundEndpointFactoryBean;
import org.mule.module.atom.routing.FeedSplitter;
import org.mule.module.atom.routing.URIRouteFilter;
import org.mule.module.atom.transformers.AtomEntryBuilderTransformer;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class AtomNamespaceHandler extends NamespaceHandlerSupport
{
    public void init()
    {
        registerBeanDefinitionParser("inbound-endpoint", new TransportEndpointDefinitionParser("atom", true, AtomInboundEndpointFactoryBean.class, new String[]{"lastUpdate", "splitFeed", "acceptedMimeTypes", "pollingFrequency"}, new String[][]{}, new String[][]{}));

        registerBeanDefinitionParser("route-filter", new ChildDefinitionParser("filter", URIRouteFilter.class));
        registerBeanDefinitionParser("feed-splitter", new RouterDefinitionParser(FeedSplitter.class));
        registerBeanDefinitionParser("component", new ComponentDefinitionParser(AbderaServiceComponent.class));
        registerBeanDefinitionParser("entry-builder-transformer", new MessageProcessorDefinitionParser(AtomEntryBuilderTransformer.class));
        registerBeanDefinitionParser("entry-property", new ChildDefinitionParser("argument", ExpressionArgument.class));

    }
}


