/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.api.ws;

public enum WebSocketCloseCode {

  /**
   * Indicates a normal closure, meaning whatever purpose the connection was established for has been fulfilled.
   */
  NORMAL_CLOSURE,
  /**
   * Indicates that an endpoint is "going away", such as a server going down, or a browser having navigated away from
   * a page.
   */
  END_POINT_GOING_DOWN,
  /**
   * Indicates that an endpoint is terminating the connection due to a protocol error.
   */
  PROTOCOL_ERROR,
  /**
   * Indicates that an endpoint is terminating the connection because it has received a type of data it cannot accept
   * (e.g. an endpoint that understands only text data may send this if it receives a binary message.)
   */
  INVALID_DATA,
  /**
   * indicates that an endpoint is terminating the connection because it has received a message that is too large.
   */
  MESSAGE_TOO_LARGE;

}
