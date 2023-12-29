import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try (Stream<String> lines = Files.lines(Paths.get(source))) {
            data = lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Before");
        System.out.println(data);
    }


    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(processors.size());
        try {
            List<Future<?>> futures = processors.parallelStream()
                    .map(processor -> executorService.submit(() -> processWithAnnotation(processor)))
                    .collect(Collectors.toList());

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {
            executorService.shutdown();
        }
    }


    private void processWithAnnotation(Object processor) {
        Method[] methods = processor.getClass().getMethods();


        for (Method method : methods) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                try {
                    method.invoke(processor, data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveData(String destination) {
        System.out.println("After");
        System.out.println(data);
        try {
            Files.write(Paths.get(destination), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
