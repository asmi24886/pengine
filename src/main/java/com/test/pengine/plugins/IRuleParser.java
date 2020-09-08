package com.test.pengine.plugins;

import java.util.Map;

public interface IRuleParser {

    double apply(Map<String, Integer> itemQuantityMap); //This is extensible. Any further rule can be supported once this Interface is implemented
}
