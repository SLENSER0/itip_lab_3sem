public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new TransformDataProcessor());
        dataManager.registerDataProcessor(new DeduplicateProcessor());

        dataManager.loadData("src/test.txt");

        dataManager.processData();
        dataManager.saveData("src/output.txt");

    }
}