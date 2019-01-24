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
package org.openjdk.jmh.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>OperationsPerInvocation annotations allows to communicate the benchmark does more than
 * one operation, and let JMH to adjust the scores appropriately.</p>
 *
 * <p>For example, a benchmark which uses the internal loop to have multiple operations, may
 * want to measure the performance of a single operation:</p>
 *
 * <blockquote><pre>
 * &#64;Benchmark
 * &#64;OperationsPerInvocation(10)
 * public void test() {
 *      for (int i = 0; i &lt; 10; i++) {
 *          // do something
 *      }
 * }
 * </pre></blockquote>
 *
 * <p>This annotation may be put at {@link Benchmark} method to have effect on that method
 * only, or at the enclosing class instance to have the effect over all {@link Benchmark}
 * methods in the class.</p>
 */
@Inherited
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationsPerInvocation {

    /**
     * @return Number of operations per single {@link Benchmark} call.
     */
    int value() default 1;

}

