/*
 * Copyright (c) 2011, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */
package com.cloudera.recordbreaker.analyzer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/******************************************************************
 * <code>XMLDataDescriptor</code> captures information about an HDFS .xml file.
 *
 * @author "Michael Cafarella"
 * @version 1.0
 * @since 1.0
 * @see DataDescriptor
 ******************************************************************/
public class XMLDataDescriptor implements DataDescriptor {
  File f;
  
  /**
   * Creates a new <code>XMLDataDescriptor</code> instance.
   */
  public XMLDataDescriptor(File f) throws IOException {
    this.f = f;
  }

  /**
   * @return the <code>File</code> value
   */
  public File getFilename() {
    return this.f;
  }

  /**
   * @return a <code>String</code> value that describes the filetype
   */
  public String getFileTypeIdentifier() {
    return "xml";
  }

  /**
   * <code>getSchemaDescriptor</code> creates (in this case) a single
   * instance of XMLSchemaDescriptor
   */
  public List<SchemaDescriptor> getSchemaDescriptor() {
    List<SchemaDescriptor> results = new ArrayList<SchemaDescriptor>();
    try {
      results.add(new XMLSchemaDescriptor(f));
    } catch (IOException iex) {
      iex.printStackTrace();
    }
    return results;
  }
}