package com.jasofalcon.nonsensegenerator.data;

import java.util.List;
import java.util.function.Supplier;

public interface MeloWordProvider {
    String provide(Supplier<List<String>> supplier);
}
