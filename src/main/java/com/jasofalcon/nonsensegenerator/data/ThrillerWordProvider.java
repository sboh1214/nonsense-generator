package com.jasofalcon.nonsensegenerator.data;

import java.util.List;
import java.util.function.Supplier;

public interface ThrillerWordProvider {
    String provide(Supplier<List<String>> supplier);
}
