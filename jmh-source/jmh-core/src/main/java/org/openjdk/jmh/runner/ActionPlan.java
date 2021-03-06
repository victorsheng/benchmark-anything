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
package org.openjdk.jmh.runner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * BenchMark级别的
 */
public class ActionPlan implements Serializable {
    private static final long serialVersionUID = 7250784375093638099L;

    private final List<Action> actions;
    private final ActionType type;

    public ActionPlan(ActionType type) {
        this.type = type;
        this.actions = new ArrayList<>();
    }

    public ActionType getType() {
        return type;
    }

    public void add(Action action) {
        actions.add(action);
    }

    public void mixIn(ActionPlan other) {
        actions.addAll(other.actions);
    }

    public List<Action> getActions() {
        return actions;
    }

    public List<Action> getMeasurementActions() {
        List<Action> result = new ArrayList<>();
        for (Action action : actions) {
            switch (action.getMode()) {
                case MEASUREMENT:
                case WARMUP_MEASUREMENT:
                    result.add(action);
                    break;

            }
        }
        return result;
    }

}
