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

package org.apache.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.ml.common.ParameterMap;
import org.apache.flink.ml.pipeline.FitOperation;
import org.apache.flink.ml.pipeline.PredictDataSetOperation;
import org.apache.flink.ml.recommendation.ALS;
import pojos.Link;
import pojos.Movie;
import pojos.Rating;
import pojos.Tag;

import static org.apache.flink.ml.recommendation.ALS.*;

/**
 * Skeleton for a Flink Batch Job.
 *
 * <p>For a tutorial how to write a Flink batch application, check the
 * tutorials and examples on the <a href="http://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your appliation into a JAR file for execution,
 * change the main class in the POM.xml file to this class (simply search for 'mainClass')
 * and run 'mvn clean package' on the command line.
 */
public class BatchJob {

	public static void main(String[] args) throws Exception {
		// set up the batch execution environment
		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

		DataSet<Movie> dsMovie = env.readTextFile(".store/movies.csv").map(s -> Factory.createMovie(s));
		dsMovie.writeAsText(".store/MovieSink", FileSystem.WriteMode.OVERWRITE);

		DataSet<Link> dsLink = env.readTextFile(".store/links.csv").map(s -> Factory.createLink(s));
		dsLink.writeAsText(".store/LinkSink", FileSystem.WriteMode.OVERWRITE);

		DataSet<Rating> dsRating = env.readTextFile(".store/rating4test.csv").map(s -> Factory.createRating(s));
		dsRating.writeAsText(".store/RatingSink", FileSystem.WriteMode.OVERWRITE);

		DataSet<Tag> dsTag = env.readTextFile(".store/tags.csv").map(s -> Factory.createTag(s));
		dsTag.writeAsText(".store/TagSink", FileSystem.WriteMode.OVERWRITE);

		ALS als = new ALS();
		als.setIterations(10).setBlocks(10000).setNumFactors(75000).setTemporaryPath(".store/TemporaryPath");

		ParameterMap params = new ParameterMap().add(als.Lambda, 0.9);

		als.fitALS();

		DataSet<Rating> dsTest = env.readCsvFile(".store/rating4predict.csv").ignoreFirstLine().pojoType(Rating.class, "userId", "movieId");

		als.predictRating();

		// execute program
		env.execute("Flink Batch Java API Skeleton");
	}
}
