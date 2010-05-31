/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
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

package com.cloudera.sqoop.manager;

import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.lib.db.DataDrivenDBInputFormat;
import com.cloudera.sqoop.SqoopOptions;
import org.apache.hadoop.fs.Path;

/**
 * A set of parameters describing an import operation; this is passed to
 * ConnManager.importTable() as its argument.
 */
public class ImportJobContext {

  private String tableName;
  private String jarFile;
  private SqoopOptions options;
  private Class<? extends InputFormat> inputFormatClass;
  private Path destination;

  public ImportJobContext(final String table, final String jar,
      final SqoopOptions opts, final Path destination) {
    this.tableName = table;
    this.jarFile = jar;
    this.options = opts;
    this.inputFormatClass = DataDrivenDBInputFormat.class;
    this.destination = destination;
  }

  /** @return the name of the table to import. */
  public String getTableName() {
    return tableName;
  }

  /** @return the name of the jar file containing the user's compiled
   * ORM classes to use during the import.
   */
  public String getJarFile() {
    return jarFile;
  }

  /** @return the SqoopOptions configured by the user */
  public SqoopOptions getOptions() {
    return options;
  }

  /** Set the InputFormat to use for the import job. */
  public void setInputFormat(Class<? extends InputFormat> ifClass) {
    this.inputFormatClass = ifClass;
  }

  /** @return the InputFormat to use for the import job. */
  public Class<? extends InputFormat> getInputFormat() {
    return this.inputFormatClass;
  }

  /**
   * @return the destination path to where the output files will
   * be first saved.
   */
  public Path getDestination() {
    return this.destination;
  }

}

