package Function;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrinBuilderTest {
    Logger log = LoggerFactory.getLogger(Function.StrinBuilderTest.class);

    @Test
    public void stringBuild() {
        StringBuilder sb = new StringBuilder("hah");
        sb.length();
        log.info("length=" + sb.length());
        List<String> ls = new ArrayList<>();
        ls.stream();
    }

    @Test
    public void streamReduce() { //规约
        StringBuilder sb = Stream.of("java", "python", "php", "c++").reduce(new StringBuilder(), (builder, name) -> {
            if (builder.length() > 0) {
                builder.append(",");
            }
            builder.append(name);
            return builder;
        }, (left, right) -> left.append(right));
        log.info("length=" + sb.toString());
    }


    @Test
    public void streamReduce2() { //规约
        String sb = Stream.of("java", "python", "php", "c++")
                .collect(new StringCollector("[",",","]"));
        log.info("length=" + sb.toString());
    }

    @Test
    public void streamReduce3() { //规约
        String sb = Stream.of("java", "python", "php", "c++")
                .collect(Collectors.joining(",","[","]"));
        log.info("length=" + sb.toString());
    }
    @Test
    public void collectJoin(){
        Integer integerSum = Stream.of(1, 2, 3, 4)
                .collect(new IntegerCollector());
        System.out.println("integerSum: " + integerSum); // 打印结果：integerSum: 18
    }
}
