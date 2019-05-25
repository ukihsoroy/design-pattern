package org.ko.design.principle.demeter.v2;

import org.ko.design.principle.demeter.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * TeamLeader是朋友
 * Course不是朋友
 */
public class Boss {

    public void commandCheckNumber (TeamLeader leader) {
        leader.checkNumberOfCourse();
    }
}
