package Function;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by lizw on 2017/9/24.
 */
public class IntegerCollector implements Collector<Integer,IntegerSum,Integer> {
    @Override
    public Supplier<IntegerSum> supplier() {
        return () -> new IntegerSum(2);
    }

    @Override
    public BiConsumer<IntegerSum, Integer> accumulator() {
        return IntegerSum::doSum;
    }

    @Override
    public BinaryOperator<IntegerSum> combiner() {
        return IntegerSum::doCombine;
    }

    @Override
    public Function<IntegerSum, Integer> finisher() {
        return IntegerSum::toValue;
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Collector.Characteristics> CH_NOID = Collections.emptySet();
        return CH_NOID;
    }
}
