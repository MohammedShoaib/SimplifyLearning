package com.sl.algorithms.linear.array.nge;

import org.junit.Assert;
import org.junit.Test;

import static com.sl.algorithms.core.linear.array.ArrayOps.printArray;

public class NGERegularArrayTest extends NGERegularArray {

    @Test
    public void testFindDaysToWarmthBruteForce() {
        Assert.assertEquals("[1,1,1,1,0]", printArray(findDaysToWarmthBruteForce(new int[]{1, 2, 3, 4, 5})));
        Assert.assertEquals("[1,1,4,2,1,1,0,0]", printArray(findDaysToWarmthBruteForce(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    @Test
    public void testFindDaysToWarmth() {
        Assert.assertEquals("[1,1,1,1,0]", printArray(findDaysToWarmth(new int[]{1, 2, 3, 4, 5})));
        Assert.assertEquals("[1,1,4,2,1,1,0,0]", printArray(findDaysToWarmth(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
