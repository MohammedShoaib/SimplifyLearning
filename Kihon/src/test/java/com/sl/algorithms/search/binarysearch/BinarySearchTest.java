package com.sl.algorithms.search.binarysearch;

import com.sl.algorithms.core.interfaces.search.Search;
import org.junit.Assert;
import org.junit.Test;

import static com.sl.algorithms.core.interfaces.search.Search.ELEMENT_NOT_FOUND;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;

public class BinarySearchTest {
    
    private Search<Integer> binarySearch;
    
    @Test
    public void testBinarySearchRecursive() {
        binarySearch = new RecursiveBinarySearch<>();
        testFindIndex();
    }

    @Test
    public void testBinarySearchIterative() {
        binarySearch = new IterativeBinarySearch<>();
        testFindIndex();
    }

    @Test
    public void testBinarySearchGeneric() {
        binarySearch = new GenericBinarySearch<>();
        testFindIndex();
        testFindIndexInRotatedArray();
        testRotatedArrayAllElementsSame();
        testRotatedSparsedArray();
    }

    private void testFindIndex() {
        Assert.assertEquals(0, binarySearch.findIndex(new Integer[]{1}, 1));
        Assert.assertEquals(3, binarySearch.findIndex(new Integer[]{1, 2, 3, 4, 5, 6}, 4));
        Assert.assertEquals(ELEMENT_NOT_FOUND, binarySearch.findIndex(new Integer[]{1, 2, 3, 4, 5, 6}, 10));
        Assert.assertEquals(0, binarySearch.findIndex(new Integer[]{1, 2, 3, 4, 5, 6}, 1));
        Assert.assertEquals(5, binarySearch.findIndex(new Integer[]{1, 2, 3, 4, 5, 6}, 6));
    }

    private void testFindIndexInRotatedArray() {
        { // sorted & rotated array
            Assert.assertEquals(3, binarySearch.findIndex(new Integer[]{4, 5, 1, 2, 3}, 2));
            Assert.assertEquals(0, binarySearch.findIndex(new Integer[]{4, 5, 1, 2, 3}, 4));
            Assert.assertEquals(2, binarySearch.findIndex(new Integer[]{4, 5, 1, 2, 3}, 1));
            Assert.assertEquals(1, binarySearch.findIndex(new Integer[]{3, 4, 5, 1, 2}, 4));
            Assert.assertEquals(3, binarySearch.findIndex(new Integer[]{3, 4, 5, 1, 2}, 1));
            Assert.assertEquals(2, binarySearch.findIndex(new Integer[]{3, 4, 5, 1, 2}, 5));
            Assert.assertEquals(0, binarySearch.findIndex(new Integer[]{3, 4, 5, 1, 2}, 3));
            Assert.assertEquals(4, binarySearch.findIndex(new Integer[]{3, 4, 5, 1, 2}, 2));
            Assert.assertEquals(3, binarySearch.findIndex(new Integer[]{6, 7, 1, 2, 3, 4, 5}, 2));
            Assert.assertEquals(1, binarySearch.findIndex(new Integer[]{6, 7, 1, 2, 3, 4, 5}, 7));
            Assert.assertEquals(6, binarySearch.findIndex(new Integer[]{6, 7, 1, 2, 3, 4, 5}, 5));
        }
        { // sorted, rotated array, with duplicates
            Assert.assertEquals(0, binarySearch.findIndex(new Integer[]{3, 3, 4, 5, 1, 2}, 3));
            Assert.assertEquals(2, binarySearch.findIndex(new Integer[]{3, 3, 4, 5, 1, 2}, 4));
            Assert.assertEquals(3, binarySearch.findIndex(new Integer[]{3, 3, 4, 5, 1, 2}, 5));
            Assert.assertEquals(4, binarySearch.findIndex(new Integer[]{3, 3, 4, 5, 1, 2}, 1));
            Assert.assertEquals(5, binarySearch.findIndex(new Integer[]{3, 3, 4, 5, 1, 2}, 2));
            Assert.assertEquals(0, binarySearch.findIndex(new Integer[]{3, 3, 1}, 3));
            Assert.assertEquals(8, binarySearch.findIndex(new Integer[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 4));
        }
        { // sorted, rotated, has duplicates in the position where virtual trimming of array must be done during the binary search
            Assert.assertEquals(0, binarySearch.findIndex(new Integer[]{4, 5, 6, 7, 0, 0, 1, 2}, 4));
            Assert.assertEquals(1, binarySearch.findIndex(new Integer[]{4, 5, 6, 7, 0, 0, 1, 2}, 5));
            Assert.assertThat(binarySearch.findIndex(new Integer[]{4, 5, 6, 7, 0, 0, 1, 2}, 0), anyOf(is(4), is(5))); // special case
            Assert.assertEquals(6, binarySearch.findIndex(new Integer[]{4, 5, 6, 7, 0, 0, 1, 2}, 1));
        }
        {
            Assert.assertEquals(1, binarySearch.findIndex(new Integer[]{1, 3, 1, 1, 1}, 3));
        }
    }

    private void testRotatedArrayAllElementsSame() {
        { // sorted, rotated, all elements are same
            Assert.assertThat(binarySearch.findIndex(new Integer[]{1, 1, 1}, 1), anyOf(is(1), is(0))); // special case
        }
    }

    private void testRotatedSparsedArray() {
        {
            Assert.assertEquals(2, binarySearch.findIndex(new Integer[]{1, 1, 2, 1, 1}, 2));
            Assert.assertEquals(2, binarySearch.findIndex(new Integer[]{1, 1, 2, 1, 1, 1}, 2));
            Assert.assertEquals(3, binarySearch.findIndex(new Integer[]{1, 1, 1, 2, 1, 1}, 2));
        }
        {
            Integer[] highlySparsedArray = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            Assert.assertEquals(699, binarySearch.findIndex(highlySparsedArray, 2));
        }
    }
    
    @Test
    public void testFindStartOfRotation() {
        binarySearch = new GenericBinarySearch<>();
        { // single element
            Assert.assertEquals(0, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{1}));
        }
        { // regular sorted array
            Assert.assertEquals(0, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{1, 2, 3, 4, 5}));
        }
        { // sorted array, with duplicates
            Assert.assertEquals(0, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{1, 2, 3, 3, 4, 5}));
        }
        { // sorted & rotated array
            Assert.assertEquals(2, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{4, 5, 1, 2, 3}));
            Assert.assertEquals(3, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{3, 4, 5, 1, 2}));
        }
        { // sorted, rotated array, with duplicates
            Assert.assertEquals(4, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{3, 3, 4, 5, 1, 2}));
            Assert.assertEquals(2, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{3, 3, 1}));
        }
        { // sorted, rotated, all elements same
            Assert.assertEquals(0, ((GenericBinarySearch<Integer>) binarySearch).findStartOfAscent(new Integer[]{1, 1, 1}));
        }
    }
}
