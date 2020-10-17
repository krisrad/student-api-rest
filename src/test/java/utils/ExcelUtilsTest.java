package utils;

public class ExcelUtilsTest {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String workbookPath = projectPath + "/data/TestData.xlsx";
        String sheetName = "users";
        ExcelUtils excel = new ExcelUtils(workbookPath, sheetName);
        excel.getCellData(1,0);
        excel.getCellData(1,1);
        excel.getCellData(1,2);
    }
}
