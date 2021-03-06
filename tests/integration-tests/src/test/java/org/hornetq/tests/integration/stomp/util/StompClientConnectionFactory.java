/*
 * Copyright 2010 Red Hat, Inc.
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.hornetq.tests.integration.stomp.util;

import java.io.IOException;

/**
 * 
 * @author <a href="mailto:hgao@redhat.com">Howard Gao</a>
 *
 */
public class StompClientConnectionFactory
{
   //create a raw connection to the host.
   public static StompClientConnection createClientConnection(String version, String host, int port) throws IOException
   {
      if ("1.0".equals(version))
      {
         return new StompClientConnectionV10(host, port);
      }
      if ("1.1".equals(version))
      {
         return new StompClientConnectionV11(host, port);
      }
      return null;
   }

   public static void main(String[] args) throws Exception
   {
      StompClientConnection connection = StompClientConnectionFactory.createClientConnection("1.0", "localhost", 61613);
      
      System.out.println("created a new connection: " + connection);
      
      connection.connect();
      
      System.out.println("connected.");
      
      connection.disconnect();
      System.out.println("Simple stomp client works.");
      
   }
}
