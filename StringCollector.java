package Function;

import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class StringCollector implements Collector<String,StringJoiner,String> {
    private  String prefix;
    private  String delimiter;
    private  String suffix;
    public StringCollector(String delimiter,
                           String prefix,
                           String suffix) {
        this.prefix = prefix;
        this.delimiter = delimiter;
        this.suffix = suffix;
    }


    @Override
    public Supplier supplier() {    //创建容器

        return ()->new StringJoiner(prefix,delimiter,suffix);
    }

    @Override
    public BiConsumer<StringJoiner,String> accumulator() {    //将元素添加到收集器中
        return StringJoiner::add;
    }

    @Override
    public BinaryOperator<StringJoiner> combiner() {    //合并容器
        return StringJoiner::merge;
    }

    @Override
    public Function<StringJoiner,String> finisher() {
        return StringJoiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
