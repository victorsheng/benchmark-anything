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
package org.openjdk.jmh.ct.params;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.ct.CompileTest;

@State(Scope.Benchmark)
public class ParamAccessPrivateTest {

    @Param("true")
    private boolean param_boolean;

    @Param("0")
    private byte param_byte;

    @Param("0")
    private short param_short;

    @Param("0")
    private char param_char;

    @Param("0")
    private int param_int;

    @Param("0")
    private float param_float;

    @Param("0")
    private long param_long;

    @Param("0")
    private double param_double;

    @Param("true")
    private Boolean param_Boolean;

    @Param("0")
    private Byte param_Byte;

    @Param("0")
    private Short param_Short;

    @Param("0")
    private Character param_Char;

    @Param("0")
    private Integer param_Int;

    @Param("0")
    private Float param_Float;

    @Param("0")
    private Long param_Long;

    @Param("0")
    private Double param_Double;

    @Param("null")
    private String param_String;

    @Benchmark
    public void test() {

    }

    @Test
    public void compileTest() {
        CompileTest.assertOK(this.getClass());
    }

}
