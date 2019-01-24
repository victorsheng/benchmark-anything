/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
package org.openjdk.jmh.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BlackholePipelineBench {

    @Param("10")
    private int steps;

    private boolean[] booleans;
    private byte[] bytes;
    private short[] shorts;
    private char[] chars;
    private int[] ints;
    private float[] floats;
    private long[] longs;
    private double[] doubles;
    private Object[] objects;
    private Object[][] arrays;

    @Setup
    public void prepare() {
        booleans = new boolean[steps];
        bytes = new byte[steps];
        shorts = new short[steps];
        chars = new char[steps];
        ints = new int[steps];
        floats = new float[steps];
        longs = new long[steps];
        doubles = new double[steps];
        objects = new Object[steps];
        arrays = new Object[steps][];

        Random r = new Random(0);
        for (int c = 0; c < steps; c++) {
            booleans[c] = r.nextBoolean();
            bytes[c] = (byte) r.nextInt();
            shorts[c] = (short) r.nextInt();
            chars[c] = (char) r.nextInt();
            ints[c] = r.nextInt();
            floats[c] = r.nextFloat();
            longs[c] = r.nextLong();
            doubles[c] = r.nextDouble();
            objects[c] = new Object();
            arrays[c] = new Object[10];
        }
    }

    @Benchmark
    public void test_boolean(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(booleans[c]);
        }
    }

    @Benchmark
    public void test_byte(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(bytes[c]);
        }
    }

    @Benchmark
    public void test_short(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(shorts[c]);
        }
    }

    @Benchmark
    public void test_char(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(chars[c]);
        }
    }

    @Benchmark
    public void test_int(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(ints[c]);
        }
    }

    @Benchmark
    public void test_float(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(floats[c]);
        }
    }

    @Benchmark
    public void test_long(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(longs[c]);
        }
    }

    @Benchmark
    public void test_double(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(doubles[c]);
        }
    }

    @Benchmark
    public void test_Object(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(objects[c]);
        }
    }

    @Benchmark
    public void test_Array(Blackhole bh) {
        for (int c = 0; c < steps; c++) {
            bh.consume(arrays[c]);
        }
    }

}
