package com.gnp.ioth.leshan;

import org.eclipse.leshan.core.node.codec.DefaultLwM2mNodeDecoder;
import org.eclipse.leshan.core.node.codec.DefaultLwM2mNodeEncoder;
import org.eclipse.leshan.core.node.codec.LwM2mNodeDecoder;
import org.eclipse.leshan.server.californium.LeshanServerBuilder;
import org.eclipse.leshan.server.californium.impl.LeshanServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeshanServerWrapper {
  private static final Logger LOG = LoggerFactory.getLogger(LeshanServerWrapper.class);

  public LeshanServerWrapper() {
    // Prepare LWM2M server
    LeshanServerBuilder builder = new LeshanServerBuilder();
    builder.setEncoder(new DefaultLwM2mNodeEncoder());
    LwM2mNodeDecoder decoder = new DefaultLwM2mNodeDecoder();
    builder.setDecoder(decoder);

    // Create and start LWM2M server
    LeshanServer lwServer = builder.build();
    lwServer.start();
    LOG.info("LWM2M server started.");
  }

}
