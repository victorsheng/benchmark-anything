/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.openjdk.jmh.it.batchsize;

import junit.framework.Assert;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.it.Fixtures;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.util.Statistics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@State(Scope.Thread)
public class BatchSizeSanityTest {

    private static final int SLEEP_TIME_MS = 1;

    @Benchmark
    public void test() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(SLEEP_TIME_MS);
    }

    @Test
    public void invokeAPI() throws RunnerException {
        for (int bs : new int[] {1, 10, 100}) {
            for (Mode m : Mode.values()) {
                if (m == Mode.All) continue;
                doWith(m, bs);
            }
        }
    }

    private void doWith(Mode mode, int batchSize) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(Fixtures.getTestMask(this.getClass()))
            .shouldFailOnError(true)
            .warmupIterations(0)
            .measurementTime(TimeValue.seconds(1))
            .measurementIterations(5)
            .forks(1)
            .timeUnit(TimeUnit.MILLISECONDS)
            .measurementBatchSize(batchSize)
            .mode(mode)
            .build();
        RunResult run = new Runner(opt).runSingle();

        final double TOLERANCE = 0.30;

        double expectedScore;
        double actualScore;
        Statistics stats = run.getPrimaryResult().getStatistics();

        switch (mode) {
            case Throughput:
                expectedScore = 1.0 / (1.0 * SLEEP_TIME_MS * batchSize);
                actualScore   = stats.getMax();
                break;
            case AverageTime:
            case SampleTime:
            case SingleShotTime:
                expectedScore = SLEEP_TIME_MS * batchSize;
                actualScore   = stats.getMin();
                break;
            default:
                expectedScore = Double.NaN;
                actualScore   = Double.NaN;
                Assert.fail("Unhandled mode: " + mode);
        }

        Assert.assertTrue(mode + ", " + batchSize + ": " + expectedScore + " vs " + actualScore,
                Math.abs(1 - actualScore / expectedScore) < TOLERANCE);
    }

}
