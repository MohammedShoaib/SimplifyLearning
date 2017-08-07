package com.sl.rest.service;

import com.sl.algorithms.AlgoUtility;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class KinderRESTController {

    private static final String HELLO_STR = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * For a given input 'name', output the JSON form of "Hello 'name'".
     *
     * @param name
     * @return KinderRESTResource, in JSON format
     */
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public KinderRESTResource sayHello(@RequestParam(value = "name", required = true, defaultValue = "World") String name) {
        return new KinderRESTResource(counter.incrementAndGet(), String.format(HELLO_STR, name));
    }

    /**
     * Apply Binary Search to find the position of a number in a sorted array.
     *
     * @return int, position of the required number
     */
    @RequestMapping(method = RequestMethod.GET, path = "/binarySearch/[{sortedInput}]")
    public int searchBinary(@PathVariable int[] sortedInput,
                            @RequestParam(value = "numberToSearch", required = true) int numberToSearch) {
        return AlgoUtility.binarySearch(sortedInput, numberToSearch);
    }
}