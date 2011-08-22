/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreemnets.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.tools.cmdline.chunker;

import java.io.OutputStream;

import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.util.eval.EvaluationMonitor;

/**
 * A default implementation of {@link EvaluationMonitor} that prints
 * to an output stream.
 * 
 */
public class ChunkEvaluationErrorListener extends
    EvaluationErrorPrinter<ChunkSample> {

  /**
   * Creates a listener that will print to System.err
   */
  public ChunkEvaluationErrorListener() {
    super(System.err);
  }

  /**
   * Creates a listener that will print to a given {@link OutputStream}
   */
  public ChunkEvaluationErrorListener(OutputStream outputStream) {
    super(outputStream);
  }

  public void missclassified(ChunkSample reference, ChunkSample prediction) {
    printError(reference.getPhrasesAsSpanList(),
        prediction.getPhrasesAsSpanList(), reference, prediction,
        reference.getSentence());
  }

}
