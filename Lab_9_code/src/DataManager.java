import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataManager {
    private ArrayList<App> tasks;
    private ExecutorService service;
    private ArrayList<String> data;
    private String outputData = "";

    public DataManager() {
        this.tasks = new ArrayList<>();
        this.service = Executors.newFixedThreadPool(2);
        this.data = new ArrayList<String>();
    }

    public static void main(String[] args) throws Exception {
        DataManager manager = new DataManager();
        OneLine processor = new OneLine();
        OneRow processor1 = new OneRow();
        manager.registerDataProcessor(processor);
        manager.registerDataProcessor(processor1);
        manager.loadData("1.txt");
        manager.processData();
        manager.saveData("2.txt");
    }
    
    public void registerDataProcessor(App task) {
        tasks.add(task);
    }

    public void loadData(String source) {
        File file = new File(source);
        try (FileReader reader = new FileReader(file);) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                data.add(line);
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void processData() {
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (App task : tasks) {
            for (Method method : task.getClass().getMethods()) {
                if (method.getAnnotation(DataProcessor.class) != null) {
                    futures.add(service.submit(() -> {
                        try {
                            String s = method.invoke(task, data).toString();
                            System.out.println(s);
                            return s;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return "";
                        }
                    }));
                }
            }
        }
        for (Future<String> f : futures) {
            try {
                outputData += f.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        service.shutdown();
    }

    public void saveData(String destination) {
        File file = new File(destination);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(outputData + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
